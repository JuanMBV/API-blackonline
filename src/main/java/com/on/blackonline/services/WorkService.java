package com.on.blackonline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.on.blackonline.persistences.entities.WorkEntity;
import com.on.blackonline.persistences.repositories.WorkRepository;

@Service
public class WorkService {

    @Autowired
    WorkRepository workRepository;

    public WorkEntity getWork(Long id){
        return workRepository.findById(id).get();
    }

    public List<WorkEntity> getWorks(){
        return workRepository.findAll();
    }
    
    public WorkEntity saveWork(WorkEntity work){
        return workRepository.save(work);
    }

    public WorkEntity updateWork(WorkEntity request, Long id){
        WorkEntity work = workRepository.findById(id).get();

        work.setName(request.getName());
        work.setDescription(request.getDescription());
        work.set_long(request.get_long());
        work.setHeight(request.getHeight());
        work.setWidth(request.getWidth());
        work.setDiameter(request.getDiameter());
        work.setCircumference(request.getCircumference());
        work.setThickness(request.getThickness());

        return workRepository.save(work);
    }

    public void deleteWork(Long id){
        workRepository.deleteById(id);
    }
}
