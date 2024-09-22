package com.jali.repos.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepo extends JpaRepository<WishListDataModel, WishListDataModel.WishlistId> {

    
} 
