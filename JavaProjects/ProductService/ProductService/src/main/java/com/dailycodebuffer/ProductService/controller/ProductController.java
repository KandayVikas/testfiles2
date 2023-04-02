package com.dailycodebuffer.ProductService.controller;

import com.dailycodebuffer.ProductService.model.ProductRequest;
import com.dailycodebuffer.ProductService.model.ProductResponse;
import com.dailycodebuffer.ProductService.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    private ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
     Long productId=productService.addProduct(productRequest);
     return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }
    //Order Entity -> Save the data with the status Order created
    //Product Service -> Block the products (Reduce the quantity)
    //Payment Service -> Payments -> SUCCESS -> COMPLETE ELSE -> CANCELLED

    @GetMapping("/{id}")
    private ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId){
            ProductResponse productResponse=productService.getProductById(productId);
            return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long id, @RequestParam long quantity){
          productService.reduceQuantity(id,quantity);
          return new ResponseEntity<>(HttpStatus.OK);
    }

}
