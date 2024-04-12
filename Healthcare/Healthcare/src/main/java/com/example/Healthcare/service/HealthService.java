package com.example.Healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Healthcare.model.HealthModel;
import com.example.Healthcare.repository.HealthRepository;

@Service
@Transactional
public class HealthService {

    private final HealthRepository healthRepository;

    public HealthService(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }

    public HealthModel saveHealthData(HealthModel healthModel) {
        return healthRepository.save(healthModel);
    }

    public List<HealthModel> getAllHealthData() {
        return healthRepository.findAll();
    }

    public Optional<HealthModel> getHealthDataById(Long id) {
        return healthRepository.findById(id);
    }

    public HealthModel updateHealthData(Long id, HealthModel updatedData) {
        if (healthRepository.existsById(id)) {
            updatedData.setId(id);
            return healthRepository.save(updatedData);
        }
        return null; 
    }

    @Transactional 
    public void deleteHealthData(Long id) {
        healthRepository.deleteById(id);
    }

    @Transactional 
    public void deleteHealthDataByEmail(String email) {
        healthRepository.deleteByEmail(email);
    }

    public HealthModel updateHealthcareByEmail(String email, HealthModel healthcare) {
        Optional<HealthModel> existingHealthcare = healthRepository.findByEmail(email);
        if (existingHealthcare.isPresent()) {
            healthcare.setId(existingHealthcare.get().getId());
            return healthRepository.save(healthcare);
        } else {
            return null;
        }
    }

    public List<HealthModel> getAllHealthDatas(int offset, int pagesize){
        Pageable page = PageRequest.of(offset, pagesize);
        Page<HealthModel> pageResult = healthRepository.findAll(page);
        return pageResult.getContent();
    }

    public List<HealthModel> getAllHealthDatasSorted(String field){
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return healthRepository.findAll(sort);
    }

    public List<HealthModel> getAllHealthDatasSortedAndPaginated(int offset, int pagesize, String field) {
        Pageable page = PageRequest.of(offset, pagesize, Sort.by(field).ascending());
        Page<HealthModel> pageResult = healthRepository.findAll(page);
        return pageResult.getContent();
    }
    
    public Optional<HealthModel> getHealthcareByEmail(String email) {
        return healthRepository.findByEmail(email);
    }
}
