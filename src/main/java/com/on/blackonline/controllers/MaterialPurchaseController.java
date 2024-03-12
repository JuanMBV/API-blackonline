package com.on.blackonline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.on.blackonline.persistences.entities.MaterialPurchaseEntity;
import com.on.blackonline.services.MaterialPurchaseService;

@RestController
@RequestMapping("/api/material-purchases")
public class MaterialPurchaseController {

    @Autowired
    private MaterialPurchaseService materialPurchaseService;

    @GetMapping("/{id}")
    private MaterialPurchaseEntity getMaterialPurchase(@PathVariable Long id) {
        return materialPurchaseService.getMaterialPurchase(id);
    }

    @GetMapping
    private List<MaterialPurchaseEntity> getMaterialPurchases() {
        return materialPurchaseService.getMaterialPurchases();
    }

    @PostMapping
    private MaterialPurchaseEntity saveMaterialPurchase(@RequestBody MaterialPurchaseEntity materialPurchase) {
        return materialPurchaseService.saveMaterialPurchase(materialPurchase);
    }

    @DeleteMapping("/{id}")
    private void deleteMaterialPurchase(@PathVariable Long id) {
        materialPurchaseService.deleteMaterialPurchase(id);
    }

    @PutMapping("/{id}")
    private MaterialPurchaseEntity updateMaterialPurchase(@RequestBody MaterialPurchaseEntity materialPurchase, @PathVariable Long id) {
        return materialPurchaseService.updateMaterialPurchase(materialPurchase, id);
    }
}
