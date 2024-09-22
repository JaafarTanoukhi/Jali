package com.jali.repos.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

import com.jali.repos.Image.ImageDataModel;
import com.jali.repos.Order.OrderDataModel;
import com.jali.repos.Seller.SellerDataModel;
import com.jali.repos.Tags.TagDataModel;
import com.jali.repos.WishList.WishListDataModel;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.*;

import org.hibernate.annotations.JoinColumnOrFormula;

import java.io.Serializable;

import com.jali.repos.Cart.CartDataModel;
import com.jali.repos.Category.CategoryDataModel;
import com.jali.repos.Genre.GenreDataModel;


@Entity
@Table(name = "Product")
public class ProductDataModel implements Serializable  {

    @Id
    private Long id;
    private String name;
    private Integer price;

    @OneToMany
    private Set<TagDataModel> tags;

    
    @OneToMany
    private Set<ImageDataModel> images;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn 
    private GenreDataModel genre;
    
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn
    private SellerDataModel seller;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn
    private OrderDataModel order;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumns({
        @JoinColumn(name = "wishlist_id", referencedColumnName = "wishlist_id"),
        @JoinColumn(name = "cart_customer_id", referencedColumnName = "customer_id")
    })
    private WishListDataModel wishlist;

    @JoinColumns({
        @JoinColumn(name = "cart_id", referencedColumnName = "cart_id"),
        @JoinColumn(name = "wishlist_customer_id", referencedColumnName = "customer_id")
    })
    @ManyToOne(fetch = FetchType.LAZY) 
    private CartDataModel cart;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "category_id", referencedColumnName="category_id"),
        @JoinColumn(name="genre_id", referencedColumnName="genre_id")
    })  
    private CategoryDataModel categoryDataModel;

    public ProductDataModel(Long id, String name,Integer price) {
        this.id = id;
        this.name = name;
        this.price=price;
        tags = new HashSet<TagDataModel>();
        images=new HashSet<ImageDataModel>();
    }

    public ProductDataModel(){}


    public void addtag(TagDataModel tag){
        tags.add(tag);
    }

    public void addtags(Set<TagDataModel> tag){
        tags.addAll(tags);
    }

    public void removeTag(TagDataModel tag){

        tags.remove(tag);

    }

    
    public void addimage(ImageDataModel image){
        images.add(image);
    }

    public void addimage(Set<ImageDataModel> images){
        images.addAll(images);
    }

    public void removeimage(ImageDataModel image){

        images.remove(image);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    
}

