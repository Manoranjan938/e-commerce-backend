package com.example.eCommDemo.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_DESC")
    private String productDesc;
    @Column(name = "PRODUCT_IMG")
    private String productImg;
    @Column(name = "PRODUCT_QUANTITY")
    private Long productQuantity;
    @Column(name = "PRODUCT_TYPE")
    private String productType;
    @Column(name = "PRODUCT_PRICE")
    private double productPrice;
    @Column(name = "PRODUCT_STATUS")
    private String productStatus;

    @Column(name = "ADDED_BY")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
