package com.example.init.customer;

import com.example.init.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomers(){
        return customerRepo.getCustomers();
    }

    public Customer getCustomer(Long id){
        return getCustomers().stream().filter(customer -> customer.getId().equals(id)).findFirst().orElseThrow(() -> new NotFoundException("Customer not found"));
    }
}
