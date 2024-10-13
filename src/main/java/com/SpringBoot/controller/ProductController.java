package com.SpringBoot.controller;

import com.SpringBoot.entity.Products;
import com.SpringBoot.exception.RecordNotFoundException;
import com.SpringBoot.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
@Slf4j
public class ProductController{

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Products> saveData(@RequestBody Products products){
        return ResponseEntity.ok(productService.saveData(products));
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAllData(){
        return ResponseEntity.ok(productService.getAllData());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Optional<Products>> findById(@PathVariable long productId){
        return ResponseEntity.ok(productService.getDataByID(productId));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deletDataById(@PathVariable long productId){
        productService.deleteDataById(productId);
        String message="product with ID: "+productId+" deleted successfully";
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Products> updateDataById( @PathVariable long productId, @RequestBody Products products){
       Optional<Products> existingProduct=productService.getDataByID(productId);
       if(existingProduct.isPresent()){
           Products products1=existingProduct.get();
           products1.setProductName(products.getProductName());
           products1.setProductDescription(products.getProductDescription());
           products1.setProductPrice(products.getProductPrice());
           return ResponseEntity.ok(productService.updateDataById(products1));
       } else {
           return ResponseEntity.notFound().build();
       }

    }

}