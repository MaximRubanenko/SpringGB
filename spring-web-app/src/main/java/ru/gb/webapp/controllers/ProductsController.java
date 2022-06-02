package ru.gb.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.webapp.model.Product;
import ru.gb.webapp.services.ProductsService;

@Controller
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }



    // GET http://localhost:8189/app/show_all
    @GetMapping(value = "/show_all")
    public String showProductsPage(Model model){
        model.addAttribute("products", productsService.findAll());
        return "products";
    }

    // GET http://localhost:8189/app/show/{id}
    @GetMapping(value = "/show/{id}")
    public String showProductPageById(Model model, @PathVariable Long id){
        model.addAttribute("product", productsService.findById(id));
        return "product_info";
    }

    // GET http://localhost:8189/app/create
    @GetMapping(value = "/create")
    public String createProduct(){
        return "create_product";
    }

    // POST http://localhost:8189/app/create
    @PostMapping(value = "/create")
    public String saveProduct(@RequestParam Long id, @RequestParam String name, @RequestParam int cost){
        productsService.save(new Product(id, name, cost));
        return "redirect:/show_all";
    }
    // GET http://localhost:8189/app/show/{id}
    @GetMapping(value = "/inc/{id}")
    public String increaseCost(Model model, @PathVariable Long id){
        model.addAttribute("product", productsService.increaseCost(id));
        return "redirect:/show_all";
    }

    // GET http://localhost:8189/app/show/{id}
    @GetMapping(value = "/dec/{id}")
    public String decreaseCost(Model model, @PathVariable Long id){
        model.addAttribute("product", productsService.decreaseCost(id));
        return "redirect:/show_all";
    }

}
