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
	public SupplierEntity getSupplier(@PathVariable Long id){
		return supplierService.getSupplier(id);
	}

	@PostMapping
	public SupplierEntity saveSupplier(@RequestBody SupplierEntity supplier){
		return supplierService.saveSupplier(supplier);
	}

	@DeleteMapping("/{id}")
	public void deleteSupplier(@PathVariable Long id){
		supplierService.deleteSupplier(id);
	}
	
	@PutMapping("/{id}")
	public SupplierEntity updateSupplier(@RequestBody SupplierEntity supplier, @PathVariable Long id){
		return supplierService.updateSupplier(supplier, id);
	}
}
