package com.workintech.Banking.service;

import com.workintech.Banking.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer find(long id);
    Customer save(Customer customer);
    Customer remove(long id);
}
