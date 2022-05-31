package ru.gb.webapp.repositories;

import org.springframework.stereotype.Component;
import ru.gb.webapp.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductsRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Телевизор", 80),
                new Product(2L, "Холодильник", 90),
                new Product(3L, "Плита", 100),
                new Product(4L, "Люстра", 90)
        ));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public void save(Product student) {
        products.add(student);
    }

    public Product findById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }
}
