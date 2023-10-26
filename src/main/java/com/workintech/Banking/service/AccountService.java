package com.workintech.Banking.service;

import com.workintech.Banking.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account find(Long id);
    Account save(Account account);
    Account remove(Long id);
}

