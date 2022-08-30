package com.example.springtest.repository;

import com.example.springtest.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Long> {
    Iterable <Product> findByNameProduct (String nameProduct);
}
