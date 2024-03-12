package com.on.blackonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.TechniqueEntity;
import com.on.blackonline.persistences.repositories.TechniqueRepository;

@Service
public class TechniqueService {

    @Autowired
    TechniqueRepository techniqueRepository;

    public List<TechniqueEntity> getTechniques(){
        return techniqueRepository.findAll();
    }

    public TechniqueEntity getTechnique(Long id){
        return techniqueRepository.findById(id).get();
    }
    
    public TechniqueEntity saveTechnique(TechniqueEntity technique){
        return techniqueRepository.save(technique);
    }

    public TechniqueEntity updateTechnique(TechniqueEntity request, Long id){
        TechniqueEntity technique = techniqueRepository.findById(id).get();

        technique.setName(request.getName());
        technique.setPrice(request.getPrice());

        return techniqueRepository.save(technique);
    }

    public void deleteTechnique(Long id){
        techniqueRepository.deleteById(id);
    }
}
