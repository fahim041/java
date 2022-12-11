package com.example.init.customer;

import com.example.init.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found"));
//        return getCustomers().stream().filter(customer -> customer.getId().equals(id)).findFirst().orElseThrow(() -> new NotFoundException("Customer not found"));
    }
}
