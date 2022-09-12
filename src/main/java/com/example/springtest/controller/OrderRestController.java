package com.example.springtest.controller;

import com.example.springtest.dto.OrderDto;
import com.example.springtest.model.Customer;
import com.example.springtest.model.Order;
import com.example.springtest.repository.CustomerRepository;
import com.example.springtest.repository.OrderRepository;
import com.example.springtest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "order1")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) {
        Long customerId = orderDto.getCustomerId();
        Customer customer = customerRepository.findById(customerId).orElse(null);
        /*if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/
        Order order = new Order();
        order.setCustomer(customer);
        Order result = orderRepository.save(order);
        return new ResponseEntity<Order>(result, HttpStatus.CREATED);
    }
}
