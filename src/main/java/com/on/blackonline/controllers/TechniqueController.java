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

import com.on.blackonline.persistences.entities.TechniqueEntity;
import com.on.blackonline.services.TechniqueService;

@RestController
@RequestMapping("/api/techniques")
public class TechniqueController {

    @Autowired
    TechniqueService techniqueService;

    @GetMapping("/{id}")
    public TechniqueEntity getTechnique(@PathVariable Long id){
        return techniqueService.getTechnique(id);
    }

    @GetMapping
    public List<TechniqueEntity> getTechniques(){
        return techniqueService.getTechniques();
    }

    @PostMapping
    public TechniqueEntity saveTechnique(@RequestBody TechniqueEntity technique){
        return techniqueService.saveTechnique(technique);
    }

    @PutMapping("/{id}")
    public TechniqueEntity updateTechnique(@RequestBody TechniqueEntity technique, @PathVariable Long id){
        return techniqueService.updateTechnique(technique, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTechnique(@PathVariable Long id){
        techniqueService.deleteTechnique(id);
    }
}
