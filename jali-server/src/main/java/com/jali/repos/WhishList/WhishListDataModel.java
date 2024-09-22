package com.jali.repos.WhishList;

import java.io.Serializable;
import java.util.ArrayList;

import com.jali.repos.Customer.CustomerDataModel;
import com.jali.repos.Product.ProductDataModel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Whishlist")
public class WhishListDataModel implements Serializable {

    @EmbeddedId
    private WishlistId Id;

    @OneToMany
    private ArrayList<ProductDataModel> products;

    public WhishListDataModel() {}

    // Constructor that takes a WhishlistId
    public WhishListDataModel(WishlistId id) {
        this.Id = id;
    }

    // Getters and Setters
    public WishlistId getId() {
        return Id;
    }

    public void setId(WishlistId id) {
        this.Id = id;
    }

    public ArrayList<ProductDataModel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductDataModel> products) {
        this.products = products;
    }

    @Embeddable
    public static class WishlistId implements Serializable {
    
        @OneToOne
        @JoinColumn(insertable = false, updatable = false)
        private CustomerDataModel customer; // Should be a CustomerDataModel, not a String
        private Long wishlistId;
    
        public WishlistId() {}
    
        public WishlistId(CustomerDataModel customer, Long wishlistId) {
            this.customer = customer;
            this.wishlistId = wishlistId;
        }
    
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((customer == null) ? 0 : customer.hashCode()); // Use customer object
            result = prime * result + ((wishlistId == null) ? 0 : wishlistId.hashCode());
            return result;
        }
    
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            WishlistId other = (WishlistId) obj;
            if (customer == null) {
                if (other.customer != null)
                    return false;
            } else if (!customer.equals(other.customer))
                return false;
            if (wishlistId == null) {
                if (other.wishlistId != null)
                    return false;
            } else if (!wishlistId.equals(other.wishlistId))
                return false;
            return true;
        }
    
        // Getters and Setters
        public CustomerDataModel getCustomer() {
            return customer;
        }
    
        public void setCustomer(CustomerDataModel customer) {
            this.customer = customer;
        }
    
        public Long getWishlistId() {
            return wishlistId;
        }
    
        public void setWishlistId(Long wishlistId) {
            this.wishlistId = wishlistId;
        }
    }
    
}
