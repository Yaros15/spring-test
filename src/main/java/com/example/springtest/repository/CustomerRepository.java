package com.example.springtest.repository;

import com.example.springtest.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository <Customer, Long> {
}
