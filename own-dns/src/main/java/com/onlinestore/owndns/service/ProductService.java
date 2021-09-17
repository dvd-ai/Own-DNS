package com.onlinestore.owndns.service;

import com.onlinestore.owndns.exception.ProductNotFoundException;
import com.onlinestore.owndns.model.Product;
import com.onlinestore.owndns.repository.ProductRepo;
import org.springframework.stereotype.Service;


/**v1*/
@Service
public class ProductService {
    
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    
    public Product findProductById(Long id) {
        return productRepo.findProductById(id).orElseThrow(
                () -> new ProductNotFoundException(getClass().getSimpleName() + " Product with id + " + id + " not found"));
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }

    public Product updateProduct(Product Product) {
        return productRepo.save(Product);
    }

}
