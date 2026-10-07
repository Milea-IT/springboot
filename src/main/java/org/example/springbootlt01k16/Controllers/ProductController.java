package org.example.springbootlt01k16.Controllers;

import org.example.springbootlt01k16.Services.ProductService;
import org.example.springbootlt01k16.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{Id}")
    public Product getProductById(@PathVariable Long Id){
        return productService.getProductById(Id);
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/{Id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long Id){
        return productService.updateProduct(product, Id);
    }

    @DeleteMapping("/{Id}")
    public void deleteProduct(@PathVariable Long Id){
        productService.deleteProduct(Id);
        return;
    }
}