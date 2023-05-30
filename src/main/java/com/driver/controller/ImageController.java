package com.driver.controller;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageService imageService;
    @PostMapping("/create")
    public ResponseEntity<Image> createAndReturn(@RequestBody Blog blog,
                                                 @RequestParam String description,
                                                 @RequestParam String dimensions) {

        Image image =  imageService.createAndReturn(blog,description,dimensions);
        return new ResponseEntity<>(image, HttpStatus.CREATED);
    }
    @GetMapping("/countImageInScreen/{id}/{screenDimension")
    public ResponseEntity<Integer> countImageInScreen(@PathVariable int id,@PathVariable String screenDimension){
        int count = 0;
        Image image = imageService.findById(id);
        count = imageService.countImagesInScreen(image,screenDimension);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable int id) {
        Image image=imageService.findById(id);
        imageService.deleteImage(image);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}