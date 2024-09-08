package com.vineeth.mystore.controller;

import com.vineeth.mystore.entities.Product;
import com.vineeth.mystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/getProducts")
    public ResponseEntity<Object> getProducts() {
        return productService.getProducts();
    }

    @PostMapping(value = "/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping(value = "/updateProduct/{productID}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long productID) {
        return null;
    }

    @DeleteMapping(value = "/deleteProduct/{productID}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long productID) {
        return null;
    }

    @GetMapping(value = "/getAllProductsByCategory")
    public ResponseEntity<Object> getAllProductsByCategory(@RequestParam String category) {
         return null;
    }

}
