package com.example.springtest.controller;

import com.example.springtest.model.Order;
import com.example.springtest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {

    OrderRepository orderRepository;

    @Autowired
    public OrderController (OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    @GetMapping
    public String ordersAllView (Model model){
        model.addAttribute("allOrder", orderRepository.findAll());
        return "order/all";
    }
}
