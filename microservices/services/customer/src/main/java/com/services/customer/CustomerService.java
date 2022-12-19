package com.services.customer;

import com.services.clients.fraud.FraudCheckResponse;
import com.services.clients.fraud.FraudClient;
import com.services.clients.notification.NotificationClient;
import com.services.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class CustomerService{

    private CustomerRepository customerRepository;
    private RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder().firstName(request.firstName()).lastName(request.lastName()).email(request.email()).build();
        customerRepository.saveAndFlush(customer);

//        FraudCheckResponse response = restTemplate.getForObject("http://fraud/api/v1/fraud-check/{customerId}/", FraudCheckResponse.class, customer.getId());

        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());

        if(response.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        notificationClient.sendNotification(
                new NotificationRequest(customer.getId(), customer.getEmail(), String.format("Hi %s, welcome to microservice", customer.getFirstName()))
        );

    }
}
