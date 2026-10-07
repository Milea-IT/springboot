package org.example.springbootlt01k16.Services;

import org.example.springbootlt01k16.Repositories.BrandRepository;
import org.example.springbootlt01k16.Repositories.CategoryRepository;
import org.example.springbootlt01k16.Repositories.ProductRepository;
import org.example.springbootlt01k16.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public BrandRepository brandRepository;

    @Autowired
    CategoryRepository categoryRepository;

    //Lấy toàn bộ product
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    //Lấy product theo id
    public Product getProductById(Long Id){
        return productRepository.findById(Id).orElseThrow(() -> new RuntimeException("Khong tim thay"));
    }

    //Tạo product
    public Product createProduct(Product product){
        Long brandId = product.getBrand().getId();
        Long categoryId = product.getCategory().getId();
        if(!brandRepository.existsById(brandId)){
            throw new RuntimeException("Khong ton tai brand");
        }
        if(!categoryRepository.existsById(categoryId)){
            throw new RuntimeException("Khong ton tai category");
        }
        return productRepository.save(product);
    }

    //Update
    public Product updateProduct(Product product, Long Id){
        Product existingProduct = getProductById(Id);
        Long newBrandId = product.getBrand().getId();
        Long newCategoryId = product.getCategory().getId();
        if(!brandRepository.existsById(newBrandId)){
            throw new RuntimeException("Khong ton tai brand");
        }
        if(!categoryRepository.existsById(newCategoryId)){
            throw new RuntimeException("Khong ton tai category");
        }
        //Update lại existing
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setCategory(product.getCategory());
        return productRepository.save(existingProduct);
    }

    //delete
    public void deleteProduct(Long Id){
        Product existingProduct = getProductById(Id);
        productRepository.delete(existingProduct);
        return;
    }
}