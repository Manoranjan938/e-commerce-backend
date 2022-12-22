package com.example.eCommDemo.response;

public class ProductListResponse {

    private Long productId;
    private String productName;

    private String productDesc;

    private double price;

    private String isInStock;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsInStock() {
        return isInStock;
    }

    public void setIsInStock(String isInStock) {
        this.isInStock = isInStock;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
