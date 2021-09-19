package com.onlinestore.owndns.controllers;

import com.onlinestore.owndns.model.Category;
import com.onlinestore.owndns.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**v1*/

@RequestMapping("/category")
@RestController
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategory(@PathVariable("id") Long id) {
        Category foundCategory = categoryService.findCategoryById(id);
        return new ResponseEntity<>(foundCategory, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> findAllCategories(Long id) {
        List<Category> foundCategories = categoryService.findAllCategories();
        return new ResponseEntity<>(foundCategories, HttpStatus.OK);
    }
}
