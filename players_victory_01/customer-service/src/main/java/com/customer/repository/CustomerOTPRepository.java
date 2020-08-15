package com.customer.repository;

import com.customer.entity.CustomerOTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOTPRepository extends JpaRepository<CustomerOTP, Long> {

    @Query("SELECT u FROM CustomerOTP u WHERE u.mobile = ?1 and u.isVerified = ?2")
    public List<CustomerOTP> getFindByMobile(@Param("mobile") String customerMobile, @Param("isVerified") String isUsed);


    @Query("SELECT u FROM CustomerOTP u WHERE u.mobile = ?1 and u.otp= ?2 and u.isVerified = ?3")
    public CustomerOTP verifyOtp(@Param("mobile") String customerMobile, @Param("otp") Integer customerOTP, @Param("isVerified") String isUsed);
}
