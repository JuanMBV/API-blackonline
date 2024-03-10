package com.on.blackonline.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.SupplierEntity;
import com.on.blackonline.persistences.repositories.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public Optional<SupplierEntity> getSupplier(Long id){
        return supplierRepository.findById(id);
    }

    public List<SupplierEntity> getSuppliers(){
        return supplierRepository.findAll();
    }

    public SupplierEntity saveSupplier(SupplierEntity supplier){
        return supplierRepository.save(supplier);
    }

    public Optional<SupplierEntity> deleteSupplier(Long id){
        Optional<SupplierEntity> supplier = supplierRepository.findById(id);
        supplierRepository.deleteById(id);
        return supplier;
    }

    public SupplierEntity updateSupplier(SupplierEntity request, Long id){
        SupplierEntity supplier = supplierRepository.findById(id).get();

        supplier.setName(request.getName());
        supplier.setPhone(request.getPhone());
        supplier.setEmail(request.getEmail());
        supplier.setAddress(request.getAddress());

        return supplierRepository.save(supplier);
    }
}
