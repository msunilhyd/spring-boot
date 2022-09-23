package com.simple.rest.webservices.controller;

import com.simple.rest.webservices.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductServiceController {

    private static Map<Integer, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product(1, "Honey");
        productRepo.put(1, honey);

        Product almond = new Product(2, "Almond");
        productRepo.put(2, almond);
    }

    @PostMapping(value="/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {

        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }

    @GetMapping(value="/products")
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @PutMapping(value="/products/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable Integer id) {
        productRepo.put(id, product);
        return new ResponseEntity<>("Product updated successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value="/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Integer id) {
        productRepo.remove(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
}
