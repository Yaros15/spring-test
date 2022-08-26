package com.example.springtest.controller;

import com.example.springtest.model.Product;
import com.example.springtest.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    ProductRepository productRepository;

    public ProductController (ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @GetMapping()
    public String productsAll (Model model){
        model.addAttribute("allProduct", productRepository.findAll());
        return "product/all";
    }

    @GetMapping("{id}")
    public String showOneProduct (@PathVariable ("id") long id, Model model){
        model.addAttribute("oneProduct",productRepository.findById(id));
        return "product/one";
    }

    @GetMapping("new")
    public String newProduct (@ModelAttribute ("addProduct") Product product){
        return "product/new";
    }

    @PostMapping()
    public String createProduct (@ModelAttribute ("addProduct") Product product){
        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping("{id}/edit")
    public String edit (Model model, @PathVariable ("id") long id){
        model.addAttribute("updateProduct", productRepository.findById(id));
        return "product/edit";
    }

    @PostMapping ("{id}")
    public String updateProduct (@ModelAttribute ("updateProduct") Product product,
                                 @PathVariable ("id") long id){
        Product productToEdit = productRepository.findById(id).get();
        productToEdit.setNameProduct(product.getNameProduct());
        productToEdit.setPrice(product.getPrice());
        productRepository.save(productToEdit);
        return "redirect:/product";
    }

    @DeleteMapping("{id}")
    public String deleteProduct (@PathVariable ("id") long id){
        productRepository.deleteById(id);
        return "redirect:/product";
    }
}
