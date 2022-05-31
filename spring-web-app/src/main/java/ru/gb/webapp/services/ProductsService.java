package ru.gb.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.webapp.model.Product;
import ru.gb.webapp.repositories.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository studentsRepository;

    @Autowired
    public ProductsService(ProductsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Product> findAll() {
        return studentsRepository.findAll();
    }

    public void save(Product student) {
        studentsRepository.save(student);
    }

    public Product findById(Long id) {
        return studentsRepository.findById(id);
    }
}
