package org.example.springbootlt01k16.Services;

import org.example.springbootlt01k16.Repositories.CategoryRepository;
import org.example.springbootlt01k16.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long Id){
        return categoryRepository.findById(Id).orElseThrow(() -> new RuntimeException("Khong tim thay"));
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category, Long Id){
        Category existingCategory = getCategoryById(Id);
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Long Id){
        Category existingCategory = getCategoryById(Id);
        categoryRepository.deleteById(Id);
        return;
    }
}