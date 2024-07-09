package com.PbAbrilDes3.mscustomer.service;

import com.PbAbrilDes3.mscustomer.entity.Customer;
import com.PbAbrilDes3.mscustomer.exception.ResourceNotFoundException;
import com.PbAbrilDes3.mscustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        return customerRepository.findById(id).map(customer -> {
            customer.setCpf(customerDetails.getCpf());
            customer.setName(customerDetails.getName());
            customer.setGender(customerDetails.getGender());
            customer.setBirthdate(customerDetails.getBirthdate());
            customer.setEmail(customerDetails.getEmail());
            customer.setPoints(customerDetails.getPoints());
            return customerRepository.save(customer);
        }).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
