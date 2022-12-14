package com.example.springtest.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "name_product")
    private String nameProduct;
    private double price;
    @OneToMany (mappedBy = "productFromTheOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> orders;


    public Product() { }

    public Product(String nameProduct, double price) {
        this.nameProduct=nameProduct;
        this.price=price;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
