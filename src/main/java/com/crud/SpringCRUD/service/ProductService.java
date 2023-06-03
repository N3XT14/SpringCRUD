package com.crud.SpringCRUD.service;

import com.crud.SpringCRUD.model.Product;
import com.crud.SpringCRUD.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product getProduct(long productId){
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public  Product updateProduct(long productId, Product product){
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not Found"));
        existingProduct.setProductName(product.getProductName());
        existingProduct.setColor(product.getColor());
        existingProduct.setPrice(product.getPrice());
        productRepository.save(existingProduct);
        return existingProduct;
    }

    public Product deleteProduct(long productId){
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not Found"));
        productRepository.deleteById(productId);
        return  existingProduct;
    }

    public List<Product> getProductByName(String productName){
        return productRepository.getProductByName(productName);
    }

}
