package com.SpringBoot.service;

import com.SpringBoot.entity.Products;
import com.SpringBoot.exception.RecordNotFoundException;
import com.SpringBoot.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @CacheEvict(value = "product", allEntries = true)
    public Products saveData(Products products){
        return productRepository.save(products);
    }

    @Cacheable(value = "product")
    public List<Products> getAllData(){
        return productRepository.findAll();
    }

    @Cacheable(value = "product", key = "#productId")
    public Optional<Products> getDataByID(long productId){
        return productRepository.findById(productId);
    }


    @CacheEvict(value = "product", allEntries = true)
    public void deleteDataById(long productId){
        Optional<Products> products=productRepository.findById(productId);
        if(products.isPresent()){
            productRepository.deleteById(productId);
        } else {
            throw new RecordNotFoundException("product with ID: "+productId+" not found");
        }
    }

    @CacheEvict(value = "product", allEntries = true)
    public Products updateDataById(Products products){
        log.info("##inside service");
        return productRepository.save(products);
    }

}
