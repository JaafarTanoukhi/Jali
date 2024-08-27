package com.jali.repos.Seller;

import com.jali.repos.Account.AccountDataModel;
import com.jali.repos.Product.ProductDataModel;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.*;

@Entity
@DiscriminatorValue("Seller")
public class SellerDataModel extends AccountDataModel {

    String imageUrl;
    String brandName;
    Boolean isTrusted;
    Integer avreageProductRating;
    String companyAddress;
    String companyEmail;
    String companyName;

    @OneToMany
    ArrayList<ProductDataModel> products;


    public SellerDataModel() {
        super();
    }

    public SellerDataModel(String Id, String email, String username, String hashedPassword, String id, String imageUrl, String brandName, Boolean isTrusted, Integer avreageProductRating, String companyAddress, String companyEmail, String companyName) {
        super(Id, email, username, hashedPassword);
        this.imageUrl = imageUrl;
        this.brandName = brandName;
        this.isTrusted = isTrusted;
        this.avreageProductRating = avreageProductRating;
        this.companyAddress = companyAddress;
        this.companyEmail = companyEmail;
        this.companyName = companyName;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
