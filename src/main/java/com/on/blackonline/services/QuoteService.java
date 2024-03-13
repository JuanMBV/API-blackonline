package com.on.blackonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.QuoteEntity;
import com.on.blackonline.persistences.repositories.QuoteRepository;

@Service
public class QuoteService {

    @Autowired
    QuoteRepository quoteRepository;

    public QuoteEntity getQuote(Long id){
        return quoteRepository.findById(id).get();
    }

    public List<QuoteEntity> getQuotes(){
        return quoteRepository.findAll();
    }

    public QuoteEntity saveQuote(QuoteEntity quote){
        return quoteRepository.save(quote);
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
