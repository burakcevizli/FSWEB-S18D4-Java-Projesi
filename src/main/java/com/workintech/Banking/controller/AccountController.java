package com.workintech.Banking.controller;

import com.workintech.Banking.dto.AccountResponse;
import com.workintech.Banking.dto.CustomerResponse;
import com.workintech.Banking.entity.Account;
import com.workintech.Banking.entity.Customer;
import com.workintech.Banking.service.AccountService;
import com.workintech.Banking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;
    private CustomerService customerService;

    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Account> findAll(){
        return accountService.findAll();
    }
    @GetMapping("/{id}")
    public Account find(@PathVariable long id) {
        return accountService.find(id);
    }

    @PostMapping("/{customerId}")
    public AccountResponse save(@RequestBody Account account, @PathVariable long customerId) {
        Customer customer = customerService.find(customerId);
        if(customer != null){
            customer.getAccounts().add(account);
            account.setCustomer(customer);
            accountService.save(account);
        } else {
            throw new RuntimeException("No Customer Found");
        }
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }

    @PutMapping("/{customerId}")
    public AccountResponse update(@RequestBody Account account,@PathVariable long customerId){
        Customer customer = customerService.find(customerId);

        Account foundAccount = null;
        for(Account account1: customer.getAccounts()){
            if(account.getId() == account1.getId()){
                foundAccount = account1;
            }
        }
        if(foundAccount == null){
            throw  new RuntimeException("Account with given id is not exist" +account.getId());
        }
        int index = customer.getAccounts().indexOf(foundAccount);
        customer.getAccounts().set(index, account);
        account.setCustomer(customer);
        accountService.save(account);

        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));

    }

    @DeleteMapping("/{id}")
    public AccountResponse remove(@PathVariable long id) {
        Account account = accountService.find(id);
        if(account != null){
            accountService.remove(id);
            return new AccountResponse(account.getId(), account.getAccountName(),
                    account.getMoneyAmount(),
                    new CustomerResponse(account.getCustomer().getId(),
                            account.getCustomer().getEmail(),
                            account.getCustomer().getSalary()));
        } else{
            throw new RuntimeException("No account found");
        }
    }





}
