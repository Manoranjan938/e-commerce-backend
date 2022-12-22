package com.example.eCommDemo.request;

import java.math.BigInteger;
import java.util.List;

public class NewOrderRequest {

    private Long orderById;

    private double totalPrice;
    private List<OrderItemRequest> orderItem;
    private String city;

    private String dist;

    private String landmark;

    private String pincode;

    private String state;

    private String street;

    private BigInteger phone;

    public Long getOrderById() {
        return orderById;
    }

    public void setOrderById(Long orderById) {
        this.orderById = orderById;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<OrderItemRequest> getOrderItem() {
        return orderItem;
    }

    public BigInteger getPhone() {
        return phone;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    public void setOrderItem(List<OrderItemRequest> orderItem) {
        this.orderItem = orderItem;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
