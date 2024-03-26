package com.eukolos.jetbrainsexposedorm.controller;

import com.eukolos.jetbrainsexposedorm.dto.CustomerDto;
import com.eukolos.jetbrainsexposedorm.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/orders/{id}")
    public CustomerDto getCustomerOrders(@PathVariable Integer id) {
        return customerService.getCustomerWithOrders(id);
    }

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/with-orders")
    public List<CustomerDto> getCustomersWithOrders() {
        return customerService.getCustomersWithOrders();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
    }

}
