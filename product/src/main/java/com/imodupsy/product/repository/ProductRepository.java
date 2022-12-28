package com.imodupsy.product.repository;

import com.imodupsy.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author iModupsy
 * @created 27/12/2022
 */
public interface ProductRepository extends MongoRepository<Product, String> {

}
