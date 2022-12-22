package com.example.eCommDemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_ATTR")
public class ProductAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRODUCT_COLOR")
    private String productColor;

    @Column(name = "PRODUCT_SIZE")
    private String productSize;
    @Column(name = "PRODUCT_ID")
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
