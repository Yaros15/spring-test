package com.example.springtest.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "orders")
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "customer_id")
    private Customer customer;

    @OneToMany (fetch = FetchType.EAGER)
    private Set<Product> products;

    public Order (){ }

    public Order (long id, Customer customer, Set<Product> products){
        this.id=id;
        this.customer = customer;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
