package com.jali.repos.Customer;

import com.jali.repos.Account.AccountDataModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "Customer")
public class CustomerDataModel extends AccountDataModel {
    public CustomerDataModel() {super();}

    
    
    
    public CustomerDataModel(String id) {
        Id = id;
    }




    public CustomerDataModel(String accountId, String email, String username, String hashedPassword) {
        super(accountId, email, username, hashedPassword);
    }
    
}
