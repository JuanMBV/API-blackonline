package com.on.blackonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.MaterialEntity;
import com.on.blackonline.persistences.repositories.MaterialRepository;

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository materialRepository;

	public MaterialEntity getMaterial(Long id){
		return materialRepository.findById(id).get();
	}

	public List<MaterialEntity> getMaterials(){
		return materialRepository.findAll();
	}

	public MaterialEntity saveMaterial(MaterialEntity material){
		return materialRepository.save(material);
	}

	public MaterialEntity updateMaterial(MaterialEntity request, Long id){
		MaterialEntity material = materialRepository.findById(id).get();

		material.setPrice(request.getPrice());
		material.setMaterialPurchase(request.getMaterialPurchase());

		return materialRepository.save(material);
	} 

	public void deleteMaterial(Long id){
		materialRepository.deleteById(id);
	}
}
