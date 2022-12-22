package com.example.eCommDemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ORDER_ITEM_NAME")
    private String orderItemName;

    @Column(name = "ORDER_ITEM_QUANTITY")
    private int orderItemQuantity;

    @Column(name = "ORDER_ITEM_PRICE")
    private  double orderItemPrice;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "ORDER_ID")
    private Long orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public int getOrderItemQuantity() {
        return orderItemQuantity;
    }

    public void setOrderItemQuantity(int orderItemQuantity) {
        this.orderItemQuantity = orderItemQuantity;
    }

    public double getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(double orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
