package com.jali.repos.Customer;

import com.jali.repos.Account.AccountDataModel;
import com.jali.repos.Cart.CartDataModel;
import com.jali.repos.WishList.WishListDataModel;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;


@Entity
@DiscriminatorValue("Customer")
public class CustomerDataModel extends AccountDataModel {


    @OneToOne
    WishListDataModel wishlist;

    @OneToOne
    CartDataModel cart;

    public CustomerDataModel() {super();}

    
    
    
    public CustomerDataModel(String id) {
        Id = id;
    }




    public CustomerDataModel(String accountId, String email, String username, String hashedPassword) {
        super(accountId, email, username, hashedPassword);
    }
    
}
