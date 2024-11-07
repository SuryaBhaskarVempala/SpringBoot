package com.Image.UploadImage.Service;

import com.Image.UploadImage.Model.Image;
import com.Image.UploadImage.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public void saveImage(MultipartFile file, String name) throws IOException {
        Image image = new Image();
        image.setName(name);
        image.setImage(file.getBytes());
        imageRepository.save(image);
    }

    public Image getImageById(int id) {
        return imageRepository.findById(id).orElse(null);
    }
}