package com.example.springtest.model;


import javax.persistence.*;

@Entity
@Table (name = "orders")
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "customer_id")
    private long customerId;
    @Column (name="product_id")
    private long productId;
    /*@ManyToOne
    @JoinColumn (name = "customer_id")
    private Customer orderByCustomer;
    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product productFromTheOrder;*/

    public Order (){ }

    public Order (long id, long customerId, long productId){
        this.id=id;
        this.customerId=customerId;
        this.productId=productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    /*public Customer getOrderByCustomer() {
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
    }*/
}
