package com.example.product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.Service.ProductService;
import com.example.product.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
    @Autowired
    private ProductService service;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
	
}
