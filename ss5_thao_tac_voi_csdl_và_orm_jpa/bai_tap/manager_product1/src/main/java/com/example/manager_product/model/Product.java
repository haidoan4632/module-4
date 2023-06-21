package com.example.manager_product.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "product_name",nullable = false,unique = true)
    private String name;
    @Column(name = "product_name",nullable = false)
    private String price;
    @Column(name = "product_name",nullable = false)
    private String describe;
    @Column(name = "product_name",nullable = false)
    private String producer;

    public Product() {
    }

    public Product(int id, String name, String price, String describe, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
