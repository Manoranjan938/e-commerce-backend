package com.example.eCommDemo.controller;

import com.example.eCommDemo.exceptions.UserNotFoundException;
import com.example.eCommDemo.request.ProductRequest;
import com.example.eCommDemo.request.UpdateProductRequest;
import com.example.eCommDemo.response.ProductDetailsResponse;
import com.example.eCommDemo.response.ProductListByUserResponse;
import com.example.eCommDemo.response.ProductListResponse;
import com.example.eCommDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @PostMapping("/new-product")
    public ResponseEntity<?> addNewProduct(@RequestBody ProductRequest pReq) throws UserNotFoundException {
        return new ResponseEntity<String>(productService.addNewProduct(pReq), HttpStatus.CREATED);
    }
    @PutMapping("/update-product/{productId}")
    public  ResponseEntity<?> updateProduct(@RequestBody UpdateProductRequest upReq, @PathVariable("productId") Long id){

        return new ResponseEntity<String>(productService.updateProduct(upReq, id), HttpStatus.OK);
    }

    @GetMapping("/get-products")
    public ResponseEntity<?> getProducts(){

        return new ResponseEntity<List<ProductListResponse>>(productService.getProductsList(), HttpStatus.OK);
    }

    @GetMapping("/get-products/{productId}")
    public ResponseEntity<?> getProductDetails(@PathVariable("productId") Long id){

        return new ResponseEntity<ProductDetailsResponse>(productService.getProductDetails(id), HttpStatus.OK);
    }

    @GetMapping("/get-products-by-user/{userId}")
    public ResponseEntity<?> getProductsByUserId(@PathVariable("userId") Long id){

        return new ResponseEntity<List<ProductListByUserResponse>>(productService.getProductsByUsers(id), HttpStatus.OK);
    }

}
