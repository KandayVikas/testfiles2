package com.dailycodebuffer.ProductService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String productName;

    private String price;

    private long quantity;
}
