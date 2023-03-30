package com.fadhilradh;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {
    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public void postCustomer(@RequestBody CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.name);
        customer.setAge(customerRequest.age);
        customer.setSavings(customerRequest.savings);
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int id, @RequestBody CustomerRequest customerRequest) {
       Customer customer = customerRepository.findById(id)
               .orElseThrow(()-> new EntityNotFoundException("Employee not exist"));

       customer.setName(customerRequest.name);
       customer.setAge(customerRequest.age);
       customer.setSavings(customerRequest.savings);

       customerRepository.save(customer);
       return ResponseEntity.ok(customer);
    }

    record CustomerRequest(String name, int age, double savings) {}
}

