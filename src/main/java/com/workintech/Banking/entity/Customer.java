package com.workintech.Banking.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer",schema = "fsweb")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private Long salary;


    //Uni-directional
    //Bi-directional
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
        private  Address address;

     @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    private List<Account> accounts;

     public void addAccount(Account account){
         if(address == null){
             accounts = new ArrayList<>();
         }
         accounts.add(account);
     }
}
