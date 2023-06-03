package com.crud.SpringCRUD.controller;

import com.crud.SpringCRUD.service.ProductService;
import com.crud.SpringCRUD.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //Inserting product into database
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product  ){
        Product saveProduct = productService.saveProduct(product);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    //Get single product by ID
    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam(name = "productId") long productId){
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //Get all the products from the database
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    //Update an existing product in database
    @PatchMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestParam(name = "productId") long productId,@RequestBody Product product){
        Product updateProduct = productService.updateProduct(productId, product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    //Delete an existing product from the database
    @DeleteMapping("/product")
    public ResponseEntity<Product> deleteProduct(@RequestParam(name = "productId") long productId){
        Product deleteProduct = productService.deleteProduct(productId);
        return new ResponseEntity<>(deleteProduct, HttpStatus.OK);
    }

    //Get product by name using RAW SQL Statement
    @GetMapping("/products-by-name")
    public List<Product> getProductByName(@RequestParam(name = "productName") String productName){
        return productService.getProductByName(productName);
    }
}
