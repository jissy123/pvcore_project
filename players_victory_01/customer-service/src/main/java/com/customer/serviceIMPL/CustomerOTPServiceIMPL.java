package com.customer.serviceIMPL;

import com.customer.Service.CustomerOTPService;
import com.customer.entity.CustomerOTP;
import com.customer.repository.CustomerOTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class CustomerOTPServiceIMPL implements CustomerOTPService {
    @Autowired
    CustomerOTPRepository customerOTPRepository;

    @Override
    public void saveOTP(CustomerOTP customerOTP) {
        //customerOTPRepository.save(customerOTP);

    }

    @Override
    public void updateOTP(CustomerOTP customerOTP) {
        customerOTP.setIsVerified("Y");
      //  customerOTPRepository.save(customerOTP);
    }

    @Override
    public List<CustomerOTP> findOTP(String customerMobile, String isUsed) {
        return customerOTPRepository.getFindByMobile(customerMobile, isUsed);
    }

    @Override
    public CustomerOTP getOtp(String customerMobile, Integer otp, String isUsed) {
        return customerOTPRepository.verifyOtp(customerMobile, otp, isUsed);
    }
}
