package com.dailycodebuffer.ProductService.service;

import com.dailycodebuffer.ProductService.entity.Product;
import com.dailycodebuffer.ProductService.exception.ProductServiceCustomException;
import com.dailycodebuffer.ProductService.model.ProductRequest;
import com.dailycodebuffer.ProductService.model.ProductResponse;
import com.dailycodebuffer.ProductService.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Long addProduct(ProductRequest productRequest) {
        log.info("Adding Product...");

        Product product=Product.
                builder().
                productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();

        productRepository.save(product);

        log.info("Product Created :>");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) throws ProductServiceCustomException {
        log.info("Get the product with productid "+productId);

        Product product = productRepository.findById(productId).
                          orElseThrow(()->new ProductServiceCustomException("Product is not availble for the productid ","PRODUCT_NOT_FOUND"));

        ProductResponse productResponse=new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);

        return productResponse;
    }

    @Override
    public void reduceQuantity(long id, long quantity) {
        log.info(" Reduce quantity {} for Id : {} ", quantity,id);
       Product product = productRepository.findById(id).orElseThrow(()->new ProductServiceCustomException("Couldn't find the product","PRODUCT_NOT_FOUND"));
       if(product.getQuantity() < quantity){
           throw new ProductServiceCustomException("Exceeded the quantity","INSUFFICIENT_QUANTITY");
       }
       product.setQuantity(product.getQuantity()-quantity);
       productRepository.save(product);


    }
}
