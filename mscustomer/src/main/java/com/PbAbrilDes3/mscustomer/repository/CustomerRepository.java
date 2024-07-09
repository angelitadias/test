package com.PbAbrilDes3.mscustomer.repository;

import com.PbAbrilDes3.mscustomer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
