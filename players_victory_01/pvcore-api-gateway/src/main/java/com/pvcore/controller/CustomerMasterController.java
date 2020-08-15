package com.pvcore.controller;

import com.core.pvcore.util.SystemException;
import com.customer.entity.CustomerModel;
import com.netflix.discovery.converters.Auto;
import com.pvcore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/book")
public class CustomerMasterController {

    @Autowired
    private ICustomerService iCustomerService;

    @RequestMapping(value = {"/customer/findInfo"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String findInfo(HttpServletRequest request) throws SystemException {
        System.out.println("I am here API _GateWay");
        Map<String, Object> params = new HashMap<>();
        iCustomerService.findInfo(params);
        return "hello-API-Gateway";
    }

    @RequestMapping(value = {"/customer/save-customer"}, method = {RequestMethod.POST})
    public CustomerModel saveCustomer(@RequestBody CustomerModel customerModel) throws SystemException {
        CustomerModel customerModel1 = iCustomerService.saveCustomerRegistration(customerModel);
        return customerModel1;
    }
}
