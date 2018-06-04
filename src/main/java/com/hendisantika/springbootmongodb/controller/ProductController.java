package com.hendisantika.springbootmongodb.controller;

import com.hendisantika.springbootmongodb.domain.Product;
import com.hendisantika.springbootmongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class ProductController {

    @Autowired
    ProductRepository productRepository;

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
    public Product show(@PathVariable String id) {
        return productRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        Product prod = productRepository.findOne(id);
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
        Product product = productRepository.findOne(id);
        productRepository.delete(product);

        return "product deleted";
    }
}
