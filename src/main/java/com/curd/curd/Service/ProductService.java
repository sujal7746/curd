package com.curd.curd.Service;

import com.curd.curd.Entity.Product;
import com.curd.curd.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    //post method


    public List<Product> saveProducts(List<Product> products){
       return repository.saveAll(products);
    }

    //Get method

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    //for del

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed !! " +id;
    }

    //update product
    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }




}
