package com.workintech.Banking.controller;

import com.workintech.Banking.entity.Address;
import com.workintech.Banking.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/address")
public class AddressController {
    private AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address address(@PathVariable long id){
        return addressService.find(id);
    }
    @PostMapping("/")
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public Address save(@RequestBody Address address, @PathVariable long id) {
        Address foundAdress = addressService.find(id);
        if (foundAdress != null) {
            address.setId(id);
            return addressService.save(address);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Address remove(@PathVariable long id) {
        return addressService.remove(id);
    }
}
