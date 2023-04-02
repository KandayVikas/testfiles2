package com.dailycodebuffer.ProductService.service;

import com.dailycodebuffer.ProductService.exception.ProductServiceCustomException;
import com.dailycodebuffer.ProductService.model.ProductRequest;
import com.dailycodebuffer.ProductService.model.ProductResponse;

public interface ProductService {
    Long addProduct(ProductRequest product);

    ProductResponse getProductById(long productId) throws ProductServiceCustomException;

    void reduceQuantity(long id, long quantity);
}
