package com.fadhilradh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void postCustomer(CustomerController.CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.name());
        customer.setAge(customerRequest.age());
        customer.setSavings(customerRequest.savings());

        customerRepository.save(customer);
    }
}
