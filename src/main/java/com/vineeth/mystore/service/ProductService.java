package com.vineeth.mystore.service;

import com.vineeth.mystore.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProductService {

    WebClient client = WebClient.builder().baseUrl("http://localhost:8081").build();

    public ResponseEntity<Object> getProducts() {
        try{
            List<Product> lst = client.get()
                    .uri("/productService/api/v1/product/getAllProducts")
                    .retrieve()
                    .bodyToFlux(Product.class)
                    .collectList().block();
            return ResponseEntity.ok().body(lst);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.internalServerError().build();
    }

    public ResponseEntity<Product> addProduct(Product product) {
        try {
            if(product!=null){
                Product response = client.post()
                        .uri("/productService/api/v1/product/addProduct")
                        .body(product,Product.class)
                        .retrieve()
                        .bodyToMono(Product.class).block();
                return ResponseEntity.ok().body(response);
            }
            System.out.println("Give the Proper Data");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ResponseEntity<Product> updateProduct(Product product, Long productID) {
        try {
            if(product!=null&&productID!=null){
                Product response = client.put()
                        .uri(uriBuilder -> uriBuilder
                                .path("/productService/api/v1/product/updateProduct/{productID}")
                                .build(productID))
                        .body(product,Product.class)
                        .retrieve()
                        .bodyToMono(Product.class).block();
                return ResponseEntity.ok().body(response);
            }
            System.out.println("Give the Proper Data");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ResponseEntity<Object> deleteProduct(Long productID) {
        try{
            if(productID!=null){
                String response = client.delete().uri(uriBuilder -> uriBuilder
                        .path("/productService/api/v1/product/deleteProduct/{productID}")
                        .build(productID))
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
                return ResponseEntity.ok().body(response);
            }
            return ResponseEntity.internalServerError().build();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ResponseEntity<Object> getAllProductsByCategory(String category) {
        if(category!=null){
            List<Product> response = client.get()
                    .uri(uriBuilder -> uriBuilder
                    .path("/productService/api/v1/product/getAllProductsByCategory/{category}").build(category))
                    .retrieve()
                    .bodyToFlux(Product.class)
                    .collectList()
                    .block();
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.internalServerError().build();
    }
}
