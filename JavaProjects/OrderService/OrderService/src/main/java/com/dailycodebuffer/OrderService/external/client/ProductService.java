package com.dailycodebuffer.OrderService.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

//used to call api which is present in other service
@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductService {

    @PutMapping("/product/reduceQuantity/{id}")
    ResponseEntity<Void> reduceQuantity(@PathVariable("id") long id, @RequestParam long quantity);
}
