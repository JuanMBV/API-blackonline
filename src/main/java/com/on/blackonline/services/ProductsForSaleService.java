package com.on.blackonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.ProductsForSaleEntity;
import com.on.blackonline.persistences.repositories.ProductsForSaleRepository;

@Service
public class ProductsForSaleService {

    @Autowired
    ProductsForSaleRepository productsForSaleRepository;

    public ProductsForSaleEntity getPfs(Long id) {
        return productsForSaleRepository.findById(id).get();
    }

    public List<ProductsForSaleEntity> getAllPfs() {
        return productsForSaleRepository.findAll();
    }

    public ProductsForSaleEntity savePfs(ProductsForSaleEntity pfs) {
        return productsForSaleRepository.save(pfs);
    }

    public ProductsForSaleEntity updatePfs(ProductsForSaleEntity request) {
        ProductsForSaleEntity pfs = productsForSaleRepository.findById(request.getPfs_id()).get();
        
        pfs.setDescription(request.getDescription());
        pfs.setPrice(request.getPrice());
        pfs.setOrder(request.getOrder());

        return productsForSaleRepository.save(pfs);
    }

    public void deletePfs(Long id) {
        productsForSaleRepository.deleteById(id);
    }
}
