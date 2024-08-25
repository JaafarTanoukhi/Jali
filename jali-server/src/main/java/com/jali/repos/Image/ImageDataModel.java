package com.jali.repos.Image;

import jakarta.persistence.Entity;

@Entity
public class ImageDataModel {
    String imageUrl;

    public ImageDataModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
}
