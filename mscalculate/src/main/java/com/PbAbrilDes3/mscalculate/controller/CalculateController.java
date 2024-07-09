package com.PbAbrilDes3.mscalculate.controller;

import com.PbAbrilDes3.mscalculate.entity.Calculate;
import com.PbAbrilDes3.mscalculate.exception.ResourceNotFoundException;
import com.PbAbrilDes3.mscalculate.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/rules")
public class CalculateController {

    @Autowired
    private CalculateService calculateService;

    @PostMapping
    public ResponseEntity<Calculate> createCalculate(@RequestBody Calculate calculate) {
        Calculate savedCalculate = calculateService.createCalculate(calculate);
        return ResponseEntity.status(201).body(savedCalculate);
    }

    @GetMapping
    public List<Calculate> getAllCalculates() {
        return calculateService.getAllCalculates();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calculate> getCalculateById(@PathVariable Long id) {
        return calculateService.getCalculateById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calculate> updateCalculate(@PathVariable Long id, @RequestBody Calculate calculateDetails) {
        try {
            Calculate updatedCalculate = calculateService.updateCalculate(id, calculateDetails);
            return ResponseEntity.ok(updatedCalculate);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalculate(@PathVariable Long id) {
        calculateService.deleteCalculate(id);
        return ResponseEntity.noContent().build();
    }
}
