package com.on.blackonline.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.on.blackonline.persistences.entities.SupplierEntity;
import com.on.blackonline.services.SupplierService;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@GetMapping
	public List<SupplierEntity> getSuppliers(){
		return supplierService.getSuppliers();
	}

	@GetMapping("/{id}")
	public Optional<SupplierEntity> getSupplier(Long id){
		return supplierService.getSupplier(id);
	}

	@PostMapping
	public SupplierEntity saveSupplier(@RequestBody SupplierEntity supplier){
		return supplierService.saveSupplier(supplier);
	}

	@DeleteMapping
	public Optional<SupplierEntity> deleteSupplier(Long id){
		return supplierService.deleteSupplier(id);
	}

	@PutMapping
	public SupplierEntity updateSupplier(@RequestBody SupplierEntity supplier, Long id){
		return supplierService.updateSupplier(supplier, id);
	}
}
