package com.on.blackonline.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.QuoteEntity;
import com.on.blackonline.persistences.entities.QuoteRequestEntity;
import com.on.blackonline.persistences.repositories.ClientRepository;
import com.on.blackonline.persistences.repositories.QuoteRepository;
import com.on.blackonline.persistences.repositories.WorkRepository;

@Service
public class QuoteService {

    @Autowired
    QuoteRepository quoteRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    WorkRepository workRepository;

    public QuoteEntity getQuote(Long id){
        return quoteRepository.findById(id).get();
    }

    public List<QuoteEntity> getQuotes(){
        return quoteRepository.findAll();
    }

    public QuoteEntity saveQuote(QuoteRequestEntity quote){
        QuoteEntity newQuote = new QuoteEntity();

        newQuote.setTotalPrice(quote.getTotalPrice());
        newQuote.setQuoteDate(LocalDateTime.now());
        newQuote.setAdvancePayment(quote.getAdvancePayment());
        newQuote.setClient(clientRepository.findById(quote.getClientId()).get());
        newQuote.setWork(workRepository.findById(quote.getWorkId()).get());

        return quoteRepository.save(newQuote);
    }

    public QuoteEntity updateQuote(QuoteEntity request, Long id){
        QuoteEntity quote = quoteRepository.findById(id).get();

        quote.setTotalPrice(request.getTotalPrice());
        quote.setQuoteDate(request.getQuoteDate());
        quote.setAdvancePayment(request.getAdvancePayment());
        quote.setClient(request.getClient());
        quote.setWork(request.getWork());

        return quoteRepository.save(quote);
    }

    public void deleteQuote(Long id){
        quoteRepository.deleteById(id);
    }
}

