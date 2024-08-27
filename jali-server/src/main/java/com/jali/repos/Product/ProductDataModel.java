package com.jali.repos.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.jali.repos.Image.ImageDataModel;
import com.jali.repos.Order.OrderDataModel;
import com.jali.repos.Seller.SellerDataModel;
import com.jali.repos.Tags.TagDataModel;
import com.jali.repos.WhishList.WhishListDataModel;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.*;
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

    @OneToMany(mappedBy = "Product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TagDataModel> tags;

    
    @OneToMany( mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ImageDataModel> images;

    @ManyToOne
    @JoinColumn(name = "genre_id") 
    private GenreDataModel genre;
    
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private SellerDataModel seller;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDataModel order;

    @ManyToOne
    @JoinColumn(name = "whishList_id")
    private WhishListDataModel whishlist;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartDataModel cart;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
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

