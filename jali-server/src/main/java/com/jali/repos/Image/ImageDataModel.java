package com.jali.repos.Image;

import java.io.Serializable;

import com.jali.repos.Product.ProductDataModel;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Image")
public class ImageDataModel implements Serializable {

    @EmbeddedId
    private ImageId Id;

    public ImageDataModel() {}

    // Constructor that takes an ImageId
    public ImageDataModel(ImageId id) {
        this.Id = id;
    }

    // Getters and Setters
    public ImageId getId() {
        return Id;
    }

    public void setId(ImageId id) {
        this.Id = id;
    }

    @Embeddable
    public static class ImageId implements Serializable {

        @ManyToOne
        @JoinColumn(insertable = false, updatable = false)
        private ProductDataModel product;

        private String imageUrl;

        public ImageId() {}

        public ImageId(ProductDataModel product, String imageUrl) {
            this.product = product;
            this.imageUrl = imageUrl;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((product == null || product.getId() == null) ? 0 : product.getId().hashCode());
            result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
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
            ImageId other = (ImageId) obj;
            if (product == null) {
                if (other.product != null)
                    return false;
            } else if (!product.getId().equals(other.product.getId()))
                return false;
            if (imageUrl == null) {
                if (other.imageUrl != null)
                    return false;
            } else if (!imageUrl.equals(other.imageUrl))
                return false;
            return true;
        }

        // Getters and Setters
        public ProductDataModel getProduct() {
            return product;
        }

        public void setProduct(ProductDataModel product) {
            this.product = product;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}
