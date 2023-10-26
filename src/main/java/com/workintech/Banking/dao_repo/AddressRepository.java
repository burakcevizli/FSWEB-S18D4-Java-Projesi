package com.workintech.Banking.dao_repo;

import com.workintech.Banking.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address , Long> {
}
