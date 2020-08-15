package com.customer.Service;

import com.customer.entity.CustomerModel;

import java.util.List;

public interface CustomerService {
    public CustomerModel saveClubUser(CustomerModel customerModel);

    public List<CustomerModel> getAllUserDetails();

    public CustomerModel findById(Long id);

    public void deleteById(Long id);

    public void updateUserDetails(CustomerModel customerModel);

    public CustomerModel findByEmailId(String email);

    public CustomerModel findByMobile(String mobile);

    public CustomerModel findUser(String mobile, String password);
}
