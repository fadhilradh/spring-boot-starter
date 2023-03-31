package com.fadhilradh;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

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

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    public ResponseEntity<Customer> updateCustomer(int id, CustomerController.CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Employee not exist"));

        customer.setName(customerRequest.name());
        customer.setAge(customerRequest.age());
        customer.setSavings(customerRequest.savings());

        customerRepository.save(customer);
        return ResponseEntity.ok(customer);
    }


}
