package com.customer.serviceIMPL;

import com.customer.Service.CustomerService;
import com.customer.comman.EmailUtil;
import com.customer.entity.CustomerModel;
import com.customer.repository.CustomerOTPRepository;
import com.customer.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = false)
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private CustomerOTPRepository customerOTPRepository;

    @Override
    public CustomerModel saveClubUser(CustomerModel customerModel) {


        customerModel.setCreateDate(new Date());
        customerModel.setIsActive("Y");
        customerModel.setIsOtpVerified("Y");
        customerModel.setIsPvVerified("N");
        customerModel.setIsEmailVerified("N");
        customerModel.setPvId(customerModel.getMobile() + "@pv");
        EmailUtil emailUtil = new EmailUtil();
        customerModel = customersRepository.save(customerModel);


        return customerModel;
    }

    public List<CustomerModel> getAllUserDetails() {
        return customersRepository.findAll();
    }

    @Override
    public CustomerModel findById(Long id) {
        return customersRepository.getFindById(id);
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateUserDetails(CustomerModel CustomerModel) {
        customersRepository.save(CustomerModel);

    }

    @Override
    public CustomerModel findByEmailId(String email) {
        return customersRepository.getFindByEmailId(email);
    }

    @Override
    public CustomerModel findByMobile(String mobile) {
        return customersRepository.getFindByMobile(mobile);
    }

    @Override
    public CustomerModel findUser(String mobile, String password) {
        return customersRepository.findByUser(mobile, password);
    }

}
