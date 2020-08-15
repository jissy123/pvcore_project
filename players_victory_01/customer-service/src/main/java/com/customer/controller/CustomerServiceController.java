package com.customer.controller;

import com.customer.Service.CustomerService;
import com.customer.entity.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CustomerServiceController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/user/findInfo")
    public CustomerModel findInfo(HttpServletRequest request) {
        System.out.println("Inside customer service");
        return null;
    }

    @PostMapping(value = "/customer/saveRegsistoer")
    public CustomerModel saveCustomerRegistration(@RequestBody CustomerModel customerModel) {
        return customerService.saveClubUser(customerModel);
    }

}
