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

import com.on.blackonline.persistences.entities.MaterialEntity;
import com.on.blackonline.services.MaterialService;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/{id}")
    private MaterialEntity getMaterial(@PathVariable Long id) {
        return materialService.getMaterial(id);
    }

    @GetMapping
    private List<MaterialEntity> getMaterials() {
        return materialService.getMaterials();
    }
    
    @PostMapping
    private MaterialEntity saveMaterial(@RequestBody MaterialEntity material) {
        return materialService.saveMaterial(material);
    }

    @PutMapping("/{id}")
    private MaterialEntity updateMaterial(@RequestBody MaterialEntity material, @PathVariable Long id){
        return materialService.updateMaterial(material, id);
    }

    @DeleteMapping("/{id}")
    private void deleteMaterial(@PathVariable Long id){
        materialService.deleteMaterial(id);
    }
}
