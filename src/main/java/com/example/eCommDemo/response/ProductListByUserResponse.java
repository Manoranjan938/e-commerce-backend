package com.example.eCommDemo.response;

import java.math.BigInteger;

public class ProductListByUserResponse {

    private String productName;

    private String productDesc;

    private double productPrice;

    private String productColor;

    private String productSize;

    private String productType;

    private BigInteger productQuantity;

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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigInteger getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(BigInteger productQuantity) {
        this.productQuantity = productQuantity;
    }
}
