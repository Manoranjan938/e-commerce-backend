package com.example.eCommDemo.request;

public class OrderItemRequest {

    private Long productId;

    private int noOfProduct;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getNoOfProduct() {
        return noOfProduct;
    }

    public void setNoOfProduct(int noOfProduct) {
        this.noOfProduct = noOfProduct;
    }
}
