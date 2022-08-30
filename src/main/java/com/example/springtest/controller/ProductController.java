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
    public String productsAll (@RequestParam(required = false, defaultValue = "") String filter,
                               Model model){
        Iterable <Product> allProduct = productRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            allProduct = productRepository.findByNameProduct(filter);
        } else {
            allProduct = productRepository.findAll();
        }

        model.addAttribute("allProduct", allProduct);
        model.addAttribute("filter", filter);

        return "product/all";
    }

    @PostMapping("new")
    public String createProduct (@RequestParam String nameProduct,
                                 @RequestParam double price){
        Product newProduct = new Product(nameProduct, price);
        productRepository.save(newProduct);
        return "redirect:/product";
    }

    @GetMapping("{id}")
    public String edit (@PathVariable ("id") long id, Model model){
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
}
