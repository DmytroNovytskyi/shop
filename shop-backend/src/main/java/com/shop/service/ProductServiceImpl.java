package com.shop.service;

import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductById(long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
