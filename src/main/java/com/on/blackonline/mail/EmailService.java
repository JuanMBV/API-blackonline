package com.on.blackonline.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.on.blackonline.auth.AuthResponse;
import com.on.blackonline.jwt.JwtService;
import com.on.blackonline.persistences.entities.ClientEntity;
import com.on.blackonline.persistences.repositories.ClientRepository;
import com.on.blackonline.services.ClientService;

import lombok.RequiredArgsConstructor;
import redis.clients.jedis.Jedis;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private EmailConfig emailConfig;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    
    private final Jedis jedis = new Jedis("localhost", 6379);

    private final String hostSMTP = "smtp.gmail.com";
    private final String portSMTP = "587";

    public String getRandomCode(){
        String code = String.valueOf((int)(Math.random()*900000)+100000);
        return code;
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity validateEmail(EmailEntity email){
        if(clientService.existsClient(email.getEmail())){
            try {
                sendEmailWithCodeToResetPassword(email);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return ResponseEntity.ok().build();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El correo proporcionado no existe");
        }
    }

    public void sendEmailWithCodeToResetPassword(EmailEntity email) throws MessagingException{
        String code = getRandomCode();

        jedis.setex(email.getEmail(), (long) 300, code);

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", hostSMTP);
        props.put("mail.smtp.port", portSMTP);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailConfig.getEmailUsername(), emailConfig.getEmailPassword());
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailConfig.getEmailUsername()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getEmail()));
        message.setSubject("Verificacion de correo electronico");
        message.setText("Código de verificacion: " + code);

        Transport.send(message);
    }

    public AuthResponse validateCode(EmailEntity request){
        String codeInRedis = jedis.get(request.getEmail());
        if(codeInRedis == null){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "El código proporcionado no es válido");
        }
        if(codeInRedis.equals(request.getCode())){
            UserDetails client = clientRepository.findByEmail(request.getEmail()).orElseThrow();
            String token = jwtService.getToken(client);
            return AuthResponse.builder()
                    .token(token)
                    .build();
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "El código proporcionado no es válido");
    }

    public ResponseEntity<ClientEntity> changePassword(ChangePasswordEntity request) {
        ClientEntity client = clientRepository.findByEmail(request.getEmail()).get();
        client.setPassword(passwordEncoder.encode(request.getPassword()));
        clientRepository.save(client);
        return ResponseEntity.ok().build();
    }
}
