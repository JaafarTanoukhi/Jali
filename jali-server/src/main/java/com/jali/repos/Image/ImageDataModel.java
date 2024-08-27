package com.jali.repos.Image;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

import com.jali.repos.Product.ProductDataModel;

@Entity
@Table(name = "Image")
public class ImageDataModel implements Serializable{
    @EmbeddedId
    ImageId Id;
    @ManyToOne
    @JoinColumn(insertable = false ,updatable = false)
    ProductDataModel product;

    public ImageDataModel(){}

    public ImageDataModel(String imageUrl, ProductDataModel product){

        this.product=product;
        this.Id=new ImageId(product.getId(), imageUrl);

    }

    


    @Embeddable
    private static class ImageId implements Serializable {
        
        Long productId;
        String imageUrl;
    
        public ImageId(Long productId,String imageUrl){
            this.productId = productId;
            this.imageUrl = imageUrl;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
            if (productId == null) {
                if (other.productId != null)
                    return false;
            } else if (!productId.equals(other.productId))
                return false;
            if (imageUrl == null) {
                if (other.imageUrl != null)
                    return false;
            } else if (!imageUrl.equals(other.imageUrl))
                return false;
            return true;
        }
        
    }
}
