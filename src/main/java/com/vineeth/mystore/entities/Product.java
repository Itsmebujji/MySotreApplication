package com.vineeth.mystore.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String productSKU;
    private String productName;
    private String productDescription;
    private String productCategory;
    private double productPrice;
    private String productImage;
    private String productStatus;
}
