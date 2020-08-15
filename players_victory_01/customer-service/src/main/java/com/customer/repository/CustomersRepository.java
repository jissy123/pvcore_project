package com.customer.repository;

import com.customer.entity.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<CustomerModel, Long> {
    @Query(" FROM CustomerModel c WHERE c.userId = :userId")
    public CustomerModel getFindById(@Param("userId") Long clubId);

    @Query(" FROM CustomerModel c WHERE c.email = :emailId")
    public CustomerModel getFindByEmailId(@Param("emailId") String emailId);

    @Query(" FROM CustomerModel c WHERE c.mobile = :mobile")
    public CustomerModel getFindByMobile(@Param("mobile") String mobile);

    @Query("FROM CustomerModel u WHERE u.mobile = ?1 and u.password = ?2")
    public CustomerModel findByUser(String mobile, String password);

}
