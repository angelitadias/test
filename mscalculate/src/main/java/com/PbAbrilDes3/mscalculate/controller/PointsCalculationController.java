package com.PbAbrilDes3.mscalculate.controller;

import com.PbAbrilDes3.mscalculate.dto.CalculateRequest;
import com.PbAbrilDes3.mscalculate.dto.CalculateResponse;
import com.PbAbrilDes3.mscalculate.service.CalculateService;
import com.PbAbrilDes3.mscalculate.service.PointsCalculationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/calculate")
public class PointsCalculationController {
    @Autowired
    private PointsCalculationService pointsCalculationService;

    @PostMapping
    public ResponseEntity<CalculateResponse> calculatePoints(@Valid @RequestBody CalculateRequest request) {
        CalculateResponse response = pointsCalculationService.calculatePoints(request);
        return ResponseEntity.ok(response);
    }

}
