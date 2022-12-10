package com.example.init.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@Primary
public class CustomerFakeRepository  implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Customer-1", "password123", "test@gmail.com"),
                new Customer(2L, "Customer-2", "123password", "test1@gmail.com")
        );
    }
}
