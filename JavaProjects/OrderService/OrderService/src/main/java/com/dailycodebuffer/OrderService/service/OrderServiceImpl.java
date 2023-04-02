package com.dailycodebuffer.OrderService.service;

import com.dailycodebuffer.OrderService.entity.Order;
import com.dailycodebuffer.OrderService.external.client.ProductService;
import com.dailycodebuffer.OrderService.model.OrderRequest;
import com.dailycodebuffer.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;


    @Override
    public long placeOrder(OrderRequest orderRequest) {
        log.info("Placing Order Request: {}",orderRequest);

        //Order Entity -> Save the data with the status Order created
        //Product Service -> Block the products (Reduce the quantity)
        //Payment Service -> Payments -> SUCCESS -> COMPLETE ELSE -> CANCELLED

       productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());

        log.info("Creating Order with status CREATED");

          Order order=Order.
                  builder().
                  productId(orderRequest.getProductId()).
                  quantity(orderRequest.getQuantity()).
                  amount(orderRequest.getTotalAmount()).
                  orderDate(Instant.now()).
                  orderStatus("CREATED").
                  build();

          orderRepository.save(order);

        log.info("Order placed successfully with order id: {}",order.getOrderId());
          return order.getOrderId();
    }
}
