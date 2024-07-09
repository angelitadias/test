package com.PbAbrilDes3.mscalculate.service;

import com.PbAbrilDes3.mscalculate.dto.CalculateRequest;
import com.PbAbrilDes3.mscalculate.dto.CalculateResponse;
import com.PbAbrilDes3.mscalculate.entity.Calculate;
import com.PbAbrilDes3.mscalculate.repository.CalculateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointsCalculationService {
    @Autowired
    private CalculateRepository calculateRepository;

    public CalculateResponse calculatePoints(CalculateRequest request) {
        Calculate rule = calculateRepository.findById(request.getCategoryId())
                .orElseGet(() -> {
                    Calculate defaultRule = new Calculate();
                    defaultRule.setCategory("Default");
                    defaultRule.setParity(1);
                    return defaultRule;
                });
        int totalPoints = request.getValue() * rule.getParity();
        CalculateResponse response = new CalculateResponse();
        response.setTotal(totalPoints);
        return response;
    }
}
