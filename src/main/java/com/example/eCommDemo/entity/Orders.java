package com.example.eCommDemo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ORDER_ID")
    private String orderId;
    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "DELIVERY_DATE")
    private Date deliveryDate;

    @Column(name = "ORDER_BY")
    private Long orderBy;

    @Column(name = "ORDER_STATE")
    private String orderForState;

    @Column(name = "ORDER_CITY")
    private String orderForCity;

    @Column(name = "ORDER_DIST")
    private String orderForDist;

    @Column(name = "ORDER_PINCODE")
    private String orderForPincode;

    @Column(name = "ORDER_LANDMARK")
    private String orderForLandmark;

    @Column(name = "ORDER_STREET")
    private String orderForStreet;

    @Column(name = "TOTAL_PRICE")
    private double totalPrice;

    @Column(name = "PAYMENT_OPTIONS")
    private String paymentOptions;

    @Column(name = "STATUS")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Long orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderForState() {
        return orderForState;
    }

    public void setOrderForState(String orderForState) {
        this.orderForState = orderForState;
    }

    public String getOrderForCity() {
        return orderForCity;
    }

    public void setOrderForCity(String orderForCity) {
        this.orderForCity = orderForCity;
    }

    public String getOrderForDist() {
        return orderForDist;
    }

    public void setOrderForDist(String orderForDist) {
        this.orderForDist = orderForDist;
    }

    public String getOrderForPincode() {
        return orderForPincode;
    }

    public void setOrderForPincode(String orderForPincode) {
        this.orderForPincode = orderForPincode;
    }

    public String getOrderForLandmark() {
        return orderForLandmark;
    }

    public void setOrderForLandmark(String orderForLandmark) {
        this.orderForLandmark = orderForLandmark;
    }

    public String getOrderForStreet() {
        return orderForStreet;
    }

    public void setOrderForStreet(String orderForStreet) {
        this.orderForStreet = orderForStreet;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(String paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @PrePersist
    protected void onCreate() {
        this.orderDate = new Date();
    }
}
