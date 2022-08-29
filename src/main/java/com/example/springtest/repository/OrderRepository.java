package com.example.springtest.repository;

import com.example.springtest.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository <Order, Long>{

}
