package com.jali.repos.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<ImageDataModel, ImageDataModel.ImageId> {

    
} 
