package com.workintech.Banking.dao_repo;

import com.workintech.Banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account , Long> {
}
