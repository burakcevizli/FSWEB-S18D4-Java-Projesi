package com.workintech.Banking.util;

import com.workintech.Banking.dto.CustomerResponse;
import com.workintech.Banking.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class EntityConverter {
    public static List<CustomerResponse> findResults(List<Customer> customers){
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer: customers){
            customerResponses.add(new CustomerResponse(customer.getId(),
                    customer.getEmail(), customer.getSalary()));
        }
        return customerResponses;
    }

    public static CustomerResponse findResult(Customer customer){
        return new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary());
    }
}
