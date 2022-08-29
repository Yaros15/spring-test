package com.example.springtest.model;


import javax.persistence.*;

@Entity
@Table (name = "orders")
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "customer_id")
    private Customer orderByCustomer;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "product_id")
    private Product productFromTheOrder;

    public Order (){ }

    public Order (long id, Customer orderByCustomer, Product productFromTheOrder){
        this.id=id;
        this.orderByCustomer = orderByCustomer;
        this.productFromTheOrder = productFromTheOrder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getOrderByCustomer() {
        return orderByCustomer;
    }

    public void setOrderByCustomer(Customer orderByCustomer) {
        this.orderByCustomer = orderByCustomer;
    }

    public Product getProductFromTheOrder() {
        return productFromTheOrder;
    }

    public void setProductFromTheOrder(Product productFromTheOrder) {
        this.productFromTheOrder = productFromTheOrder;
    }
}
