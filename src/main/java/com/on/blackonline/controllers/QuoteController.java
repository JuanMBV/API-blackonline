package com.on.blackonline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.on.blackonline.persistences.entities.QuoteEntity;
import com.on.blackonline.persistences.entities.QuoteRequestEntity;
import com.on.blackonline.services.QuoteService;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    @Autowired
    QuoteService quoteService;

    @GetMapping("/{id}")
    public QuoteEntity getQuote(@PathVariable Long id){
        return quoteService.getQuote(id);
    }  

    @GetMapping
    public List<QuoteEntity> getQuotes(){
        return quoteService.getQuotes();
    }

    @GetMapping("/pending")
    public List<QuoteEntity> getPendingCuotes(){
        return quoteService.getPendingCuotes();
    }

    @PostMapping
    public QuoteEntity saveQuote(@RequestBody QuoteRequestEntity quote){
        return quoteService.saveQuote(quote);
    }

    @PutMapping("/{id}")
    public QuoteEntity updateQuote(@RequestBody QuoteEntity quote, @PathVariable Long id){
        return quoteService.updateQuote(quote, id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuote(@PathVariable Long id){
        quoteService.deleteQuote(id);
    }
}
