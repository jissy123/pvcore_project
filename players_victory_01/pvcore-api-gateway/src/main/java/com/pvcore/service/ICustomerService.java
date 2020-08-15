package com.pvcore.service;


import com.core.pvcore.util.ServiceResult;
import com.core.pvcore.util.SystemException;
import com.customer.entity.CustomerModel;
import com.pvcore.system.UserMstServiceHystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "customer-servers", fallback = UserMstServiceHystrix.class)
public interface ICustomerService {

    @RequestMapping(value = "/user/findInfo1", method = RequestMethod.GET)
    ServiceResult<CustomerModel> findInfo(@RequestParam Map<String, Object> params) throws SystemException;

    @RequestMapping(value = "/customer/saveRegsistoer", method = RequestMethod.POST)
    CustomerModel saveCustomerRegistration(@RequestBody CustomerModel customerModel) throws SystemException;
}
