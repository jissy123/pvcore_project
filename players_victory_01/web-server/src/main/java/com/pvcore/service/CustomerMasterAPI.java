package com.pvcore.service;

import com.customer.entity.CustomerModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "pvcore-api-gateway")
public interface CustomerMasterAPI {

    @RequestMapping(value = "/customer/findInfo", method = RequestMethod.GET)
    String findInfo(@RequestParam CustomerModel customerModel);

    @RequestMapping(value = "/customer/save-customer", method = RequestMethod.POST)
    CustomerModel saveCustomerRegistration(@RequestBody CustomerModel customerModel);
}
