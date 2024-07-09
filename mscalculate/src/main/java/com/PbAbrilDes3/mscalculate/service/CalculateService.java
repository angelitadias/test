package com.PbAbrilDes3.mscalculate.service;

import com.PbAbrilDes3.mscalculate.entity.Calculate;
import com.PbAbrilDes3.mscalculate.exception.ResourceNotFoundException;
import com.PbAbrilDes3.mscalculate.repository.CalculateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalculateService {

    private CalculateRepository calculateRepository;

    public Calculate createCalculate(Calculate calculate) {
        return calculateRepository.save(calculate);
    }

    public List<Calculate> getAllCalculates() {
        return calculateRepository.findAll();
    }

    public Optional<Calculate> getCalculateById(Long id) {
        return calculateRepository.findById(id);
    }

    public Calculate updateCalculate(Long id, Calculate calculateDetails) {
        return calculateRepository.findById(id).map(calculate -> {
            calculate.setCategory(calculateDetails.getCategory());
            calculate.setParity(calculateDetails.getParity());
            return calculateRepository.save(calculate);
        }).orElseThrow(() -> new ResourceNotFoundException("Calculate not found with id" + id));
    }

    public void deleteCalculate(Long id) {
        calculateRepository.deleteById(id);
    }
}
