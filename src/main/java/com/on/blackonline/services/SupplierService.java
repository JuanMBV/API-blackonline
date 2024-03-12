package com.on.blackonline.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.SupplierEntity;
import com.on.blackonline.persistences.repositories.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public SupplierEntity saveSupplier(SupplierEntity supplier){
        return supplierRepository.save(supplier);
    }

    public SupplierEntity getSupplier(Long id){
        return supplierRepository.findById(id).get();
    }

    public List<SupplierEntity> getSuppliers(){
        return supplierRepository.findAll();
    }

    public SupplierEntity updateSupplier(SupplierEntity request, Long id){
        SupplierEntity supplier = supplierRepository.findById(id).get();

        supplier.setName(request.getName());
        supplier.setPhone(request.getPhone());
        supplier.setEmail(request.getEmail());
        supplier.setAddress(request.getAddress());

        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id){
        supplierRepository.deleteById(id);
    }
}
