package com.example.springtest.controller;

import com.example.springtest.model.Customer;
import com.example.springtest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired // необязательно писать, влюбом случае spring внедрит
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping()
    public String customersAllView (Model model){
        model.addAttribute("allCustomer", customerRepository.findAll());
        return "client/all";
    }

    @GetMapping("/{id}")
    public String showOneCustomer(@PathVariable("id") long id, Model model){
        model.addAttribute("oneCustomer", customerRepository.findById(id));
        return"client/one"; // располож и имя html кода
    }

    @GetMapping("/new")
    public String newCustomer(@ModelAttribute("addCustomer") Customer customer){
        return "client/new";
    }

    @PostMapping()
    public String createCustomer ( @ModelAttribute("addCustomer") Customer customer){
        customerRepository.save(customer);
        return "redirect:/customer";
    }


    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable ("id") long id){
        model.addAttribute("updateCustomer", customerRepository.findById(id));
         return "client/edit";
    }

    @PatchMapping ("/{id}")
    public String customerUpdate (@ModelAttribute("updateCustomer") Customer customer,
                                  @PathVariable ("id") long id){
        Customer customerToEdit = customerRepository.findById(id).get();
        //customer.setId(customerToEdit.getId());
        customer.setNameCustomer(customerToEdit.getNameCustomer());
        customer.setAge(customerToEdit.getAge());
        customerRepository.save(customer);
        System.out.println(customerRepository.findById(id).get().getNameCustomer());
        System.out.println(customer.getNameCustomer());
        return "redirect:/customer";
    }

    @DeleteMapping("{id}")
    public String delete (@PathVariable ("id") long id){
        customerRepository.deleteById(id);
        return "redirect:/customer";
    }
}