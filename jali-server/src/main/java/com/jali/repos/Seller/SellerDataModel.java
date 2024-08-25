package com.jali.repos.Seller;

import java.io.Serializable;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SellerDataModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String companyAddress;
    String imageUrl;
    String brandName;
    Boolean isTrusted;
    Integer avreageProductRating;
    String companyEmail;
    String companyName;

    public SellerDataModel(){}

    public SellerDataModel(String companyAddress, String imageUrl, String brandName, boolean isTrusted,
            Integer avreageProductRating, String companyEmail, String companyName) {


        this.companyAddress = companyAddress;
        this.imageUrl = imageUrl;
        this.brandName = brandName;
        this.isTrusted = isTrusted;
        this.avreageProductRating = avreageProductRating;
        this.companyEmail = companyEmail;
        this.companyName = companyName;
        
    }


    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }


    public String getCompanyAddress() {
        return companyAddress;
    }


    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }


    public String getImage() {
        return imageUrl;
    }


    public void setImage(String image) {
        this.imageUrl = image;
    }


    public String getBrandName() {
        return brandName;
    }


    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


    public Boolean getIsTrusted() {
        return isTrusted;
    }


    public void setIsTrusted(Boolean isTrusted) {
        this.isTrusted = isTrusted;
    }


    public Integer getAvreageProductRating() {
        return avreageProductRating;
    }


    public void setAvreageProductRating(Integer avreageProductRating) {
        this.avreageProductRating = avreageProductRating;
    }


    public String getCompanyEmail() {
        return companyEmail;
    }


    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }


    public String getCompanyName() {
        return companyName;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }



    
}
