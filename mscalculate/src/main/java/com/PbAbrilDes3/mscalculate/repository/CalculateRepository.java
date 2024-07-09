package com.PbAbrilDes3.mscalculate.repository;

import com.PbAbrilDes3.mscalculate.entity.Calculate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CalculateRepository extends JpaRepository<Calculate, Long> {
    Optional<Calculate> findByCategory(String category);
}
