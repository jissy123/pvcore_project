package com.pvcore.system;

import com.core.pvcore.util.ServiceResult;
import com.core.pvcore.util.SystemException;
import com.customer.entity.CustomerModel;
import com.pvcore.service.ICustomerService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
public class UserMstServiceHystrix implements ICustomerService {
    @Override
    public ServiceResult<CustomerModel> findInfo(@RequestParam Map<String, Object> params)
            throws SystemException {
        throw new SystemException(" Customer findInfo connection error");
    }

    @Override
    public CustomerModel saveCustomerRegistration(CustomerModel customerModel) throws SystemException {
        throw new SystemException("Customer save connection error");
    }
}
