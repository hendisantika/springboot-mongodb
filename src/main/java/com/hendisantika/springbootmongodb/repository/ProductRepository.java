package com.hendisantika.springbootmongodb.repository;

import com.hendisantika.springbootmongodb.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mongodb
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/06/18
 * Time: 15.35
 * To change this template use File | Settings | File Templates.
 */
public interface ProductRepository extends CrudRepository<Product, String> {
    @Override
    void delete(Product deleted);
}
