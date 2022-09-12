package com.example.springtest.controller;

import com.example.springtest.model.Customer;
import com.example.springtest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping()
    public String customersAllView (@RequestParam(required = false, defaultValue = "") String filter,
                                    Model model){
        Iterable <Customer> allCustomer = customerRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            allCustomer = customerRepository.findByNameCustomerContaining(filter);
        } else {
            allCustomer = customerRepository.findAll();
        }

        model.addAttribute("allCustomer", allCustomer);
        model.addAttribute("filter", filter);
        return "client/all";
    }

    @PostMapping("new")
    public String createCustomer (@RequestParam String nameCustomer,
                                  @RequestParam int age){
        Customer newCustomer = new Customer(nameCustomer, age);
        customerRepository.save(newCustomer);
        return "redirect:/customer";
    }

    @GetMapping("{id}")
    public String edit (@PathVariable ("id") long id, Model model){
        model.addAttribute("updateCustomer", customerRepository.findById(id));
         return "client/edit";
    }

    @PostMapping ("{id}")
    public String customerUpdate (@ModelAttribute("updateCustomer") Customer customer,
                                  @PathVariable ("id") long id){
        Customer customerToEdit = customerRepository.findById(id).get();
        customerToEdit.setNameCustomer(customer.getNameCustomer());
        customerToEdit.setAge(customer.getAge());
        customerRepository.save(customerToEdit);
        return "redirect:/customer";
    }
}
