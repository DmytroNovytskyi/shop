package com.shop.controller;

import com.shop.model.Product;
import com.shop.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public String getProduct(@PathVariable long productId) {
        Product product = productService.findProductById(productId);

        if (product == null) {
            return "NULL";
        }
        return product.getTitle();
    }
}
