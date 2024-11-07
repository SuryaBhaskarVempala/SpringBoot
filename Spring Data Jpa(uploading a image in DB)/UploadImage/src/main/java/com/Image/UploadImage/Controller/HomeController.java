package com.Image.UploadImage.Controller;

import com.Image.UploadImage.Model.Image;
import com.Image.UploadImage.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/image")
    public String home2(Model model){
        model.addAttribute("id",2);
        return "imageDisplay";
    }

    @PostMapping("/up")
    public String uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("name") String name , Model model) throws IOException {
        imageService.saveImage(file,name);
        model.addAttribute("result","Image Uploaded Successfully ! ");
        return "result";
    }

    @GetMapping("image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        Image image = imageService.getImageById(id);

        if (image != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);  // Adjust based on image type (e.g., JPEG, PNG)
            return new ResponseEntity<>(image.getImage(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
