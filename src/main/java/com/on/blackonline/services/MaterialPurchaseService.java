package com.on.blackonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.MaterialPurchaseEntity;
import com.on.blackonline.persistences.repositories.MaterialPurchaseRepository;

@Service
public class MaterialPurchaseService {

    @Autowired
    MaterialPurchaseRepository materialPurchaseRepository;
    
    public MaterialPurchaseEntity getMaterialPurchase(Long id){
        return materialPurchaseRepository.findById(id).get();
    }

    public List<MaterialPurchaseEntity> getMaterialPurchases(){
        return materialPurchaseRepository.findAll();
    }

    public MaterialPurchaseEntity saveMaterialPurchase(MaterialPurchaseEntity materialPurchase){
        return materialPurchaseRepository.save(materialPurchase);
    }

    public void deleteMaterialPurchase(Long id){
        materialPurchaseRepository.deleteById(id);
    }

    public MaterialPurchaseEntity updateMaterialPurchase(MaterialPurchaseEntity request, Long id){
        MaterialPurchaseEntity materialPurchase = materialPurchaseRepository.findById(id).get();

        materialPurchase.setName(request.getName());
        materialPurchase.setType(request.getType());
        materialPurchase.setQuantity(request.getQuantity());
        materialPurchase.setSquareMeters(request.getSquareMeters());
        materialPurchase.setLiters(request.getLiters());
        materialPurchase.setCost(request.getCost());
        materialPurchase.setTotalCost(request.getTotalCost());
        materialPurchase.setSupplier(request.getSupplier());

        return materialPurchaseRepository.save(materialPurchase);

    }
}
