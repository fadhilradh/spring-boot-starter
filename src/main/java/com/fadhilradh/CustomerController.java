package com.fadhilradh;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    record CustomerRequest(String name, int age, double savings) {
        public String name() {
            return name;
        }

        public int age() {
            return age;
        }

        public double savings() {
            return savings;
        }
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public void postCustomer(@RequestBody CustomerRequest customerRequest) {
        customerService.postCustomer(customerRequest);
    }
}
