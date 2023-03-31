package com.fadhilradh;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


//
//
//
//    @DeleteMapping("{customerId}")
//    public void deleteCustomer(@PathVariable("customerId") int id) {
//        customerRepository.deleteById(id);
//    }
//
//    @PutMapping("{customerId}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int id, @RequestBody CustomerRequest customerRequest) {
//       Customer customer = customerRepository.findById(id)
//               .orElseThrow(()-> new EntityNotFoundException("Employee not exist"));
//
//       customer.setName(customerRequest.name);
//       customer.setAge(customerRequest.age);
//       customer.setSavings(customerRequest.savings);
//
//       customerRepository.save(customer);
//       return ResponseEntity.ok(customer);
//    }

}

