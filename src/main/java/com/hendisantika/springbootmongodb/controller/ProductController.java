package com.hendisantika.springbootmongodb.controller;

import com.hendisantika.springbootmongodb.domain.Product;
import com.hendisantika.springbootmongodb.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mongodb
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/06/18
 * Time: 04.07
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/products")
    public Iterable<Product> product() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public String save(@RequestBody Product product) {
        productRepository.save(product);

        return product.getId();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> show(@PathVariable String id) {
        return productRepository.findById(id);
    }

    @PutMapping(value = "/products/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        Optional<Product> prodOpt = productRepository.findById(id);
        Product prod = prodOpt.get();
        if (product.getProdName() != null)
            prod.setProdName(product.getProdName());
        if (product.getProdDesc() != null)
            prod.setProdDesc(product.getProdDesc());
        if (product.getProdPrice() != null)
            prod.setProdPrice(product.getProdPrice());
        if (product.getProdImage() != null)
            prod.setProdImage(product.getProdImage());
        productRepository.save(prod);
        return prod;
    }

    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable String id) {
        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());

        return "product deleted";
    }
}
