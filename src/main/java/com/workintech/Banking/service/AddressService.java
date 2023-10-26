package com.workintech.Banking.service;

import com.workintech.Banking.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address find(Long id);
    Address save(Address address);
    Address remove(Long id);
}
