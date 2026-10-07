package org.example.springbootlt01k16.Controllers;

import org.example.springbootlt01k16.Services.CategoryService;
import org.example.springbootlt01k16.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{Id}")
    public Category getCategoryById(@PathVariable Long Id){
        return categoryService.getCategoryById(Id);
    }

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @PutMapping("/{Id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable Long Id){
        return categoryService.updateCategory(category, Id);
    }

    @DeleteMapping("/{Id}")
    public void deleteCategory(@PathVariable Long Id){
        categoryService.deleteCategory(Id);
        return;
    }
}