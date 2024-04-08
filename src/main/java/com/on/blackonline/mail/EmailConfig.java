package com.on.blackonline.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailConfig {
    
    @Value("${email.username}")
    private String emailUsername;

    @Value("${email.password}")
    private String emailPassword;

    public String getEmailUsername() {
        return emailUsername;
    }

    public String getEmailPassword() {
        return emailPassword;
    }
}
