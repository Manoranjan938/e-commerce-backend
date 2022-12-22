package com.example.eCommDemo.controller;

import com.example.eCommDemo.request.NewOrderRequest;
import com.example.eCommDemo.response.OrderDetailsResponse;
import com.example.eCommDemo.response.OrderListResponse;
import com.example.eCommDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addNewOrder")
    public ResponseEntity<?> addNewOrder(@RequestBody NewOrderRequest orderRequest){

        return new ResponseEntity<String>(orderService.addNewOrder(orderRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-orders/{userId}")
    public ResponseEntity<?> getOrderListByUserId(@PathVariable("userId") Long id){

        return new ResponseEntity<List<OrderListResponse>>(orderService.getOrdersByUser(id),HttpStatus.OK);
    }
    @GetMapping("/get-orders-details/{orderId}")
    public ResponseEntity<?> getOrderDetailsByOrderId(@PathVariable("orderId") Long id){

        return new ResponseEntity<OrderDetailsResponse>(orderService.getOrderDetailsByOrderId(id), HttpStatus.OK);
    }

}
