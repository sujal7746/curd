package com.curd.curd.Controller;

import com.curd.curd.Entity.Product;
import com.curd.curd.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;
    //post
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    //get
    @GetMapping("/Products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/Product/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/Product/{name}")
    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    //put/update

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
    //delete
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

}
