package com.example.springtest.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_customer")
    private String nameCustomer;
    private int age;

    @OneToMany (mappedBy = "orderByCustomer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> orders;


    public Customer(){  }

    public Customer (String nameCustomer, int age){
        this.nameCustomer = nameCustomer;
        this.age = age;
    }

    public long getId (){
        return id;
    }

    public void setId (long id){
        this.id = id;
    }

    public String getNameCustomer(){
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer){
        this.nameCustomer = nameCustomer;
    }

    public int getAge (){
        return age;
    }

    public void setAge (int age){
        this.age = age;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
