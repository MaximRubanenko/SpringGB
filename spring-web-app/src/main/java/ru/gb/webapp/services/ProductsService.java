package ru.gb.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.webapp.model.Product;
import ru.gb.webapp.repositories.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public void save(Product student) {
        productsRepository.save(student);
    }

    public Product findById(Long id) {
        return productsRepository.findById(id);
    }
    public Object increaseCost(Long id) {
        productsRepository.increaseCost(id);
        return null;
    }
    public Object decreaseCost(Long id) {
        productsRepository.decreaseCost(id);
        return null;
    }
}
