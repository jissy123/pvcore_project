package com.pvcore.restcontroller;

import com.customer.entity.CustomerModel;
import com.google.common.collect.Maps;
import com.pvcore.service.CustomerMasterAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerMasterAPI customerMasterAPI;

    @RequestMapping(value = "/cust")
    public String customerController() {
        Map<String, Object> result = Maps.newHashMap();
        System.out.println("Web COntroller");
        // customerMasterAPI.findInfo(result);
        return "customer rest controller";
    }

    @RequestMapping(value = "/customer-save", method = RequestMethod.POST)
    public CustomerModel customerSave(@RequestBody CustomerModel customerModel) {

        CustomerModel responceCustomer = customerMasterAPI.saveCustomerRegistration(customerModel);
        return responceCustomer;
    }
}
