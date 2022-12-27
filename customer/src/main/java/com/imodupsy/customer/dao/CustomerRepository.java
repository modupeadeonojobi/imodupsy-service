package com.imodupsy.customer.dao;

import com.imodupsy.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author iModupsy
 * @created 26/12/2022
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
