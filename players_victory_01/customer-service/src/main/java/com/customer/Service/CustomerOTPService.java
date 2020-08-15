package com.customer.Service;

import com.customer.entity.CustomerOTP;

import java.util.List;

public interface CustomerOTPService {

    public void saveOTP(CustomerOTP customerOTP);

    public void updateOTP(CustomerOTP customerOTP);

    public List<CustomerOTP> findOTP(String customerMobile, String isUsed);

    public CustomerOTP getOtp(String customerMobile, Integer otp, String isUsed);
}
