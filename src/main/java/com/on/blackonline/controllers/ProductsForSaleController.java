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

import com.on.blackonline.persistences.entities.ProductsForSaleEntity;
import com.on.blackonline.services.ProductsForSaleService;

@RestController
@RequestMapping("/api/products-for-sale")
public class ProductsForSaleController {

    @Autowired
    ProductsForSaleService productsForSaleService;
    
    @GetMapping("/{id}")
    public ProductsForSaleEntity getPfs(@PathVariable Long id) {
        return productsForSaleService.getPfs(id);
    }

    @GetMapping
    public List<ProductsForSaleEntity> getAllPfs() {
        return productsForSaleService.getAllPfs();
    }

    @PostMapping
    public ProductsForSaleEntity savePfs(@RequestBody ProductsForSaleEntity pfs) {
        return productsForSaleService.savePfs(pfs);
    }

    @PutMapping("/{id}")
    public ProductsForSaleEntity updatePfs(@RequestBody ProductsForSaleEntity request, @PathVariable Long id) {
        return productsForSaleService.updatePfs(request);
    }

    @DeleteMapping("/{id}")
    public void deletePfs(@PathVariable Long id) {
        productsForSaleService.deletePfs(id);
    }
}

