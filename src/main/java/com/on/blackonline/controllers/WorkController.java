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

import com.on.blackonline.persistences.entities.WorkEntity;
import com.on.blackonline.services.WorkService;

@RestController
@RequestMapping("/api/works")
public class WorkController {

	@Autowired
	WorkService workService;
	
	@GetMapping("/{id}")
	public WorkEntity getWork(@PathVariable Long id){
		return workService.getWork(id);
	}

	@GetMapping
	public List<WorkEntity> getWorks(){
		return workService.getWorks();
	}

	@PostMapping
	public WorkEntity saveWork(@RequestBody WorkEntity work){
		return workService.saveWork(work);
	}
	
	@PutMapping("/{id}")
	public WorkEntity updateWork(@RequestBody WorkEntity request, @PathVariable Long id){
		return workService.updateWork(request, id);
	}

	@DeleteMapping("/{id}")
	public void deleteWork(@PathVariable Long id){
		workService.deleteWork(id);
	}
}
