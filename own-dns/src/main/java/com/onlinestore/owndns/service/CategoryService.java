package com.onlinestore.owndns.service;

import com.onlinestore.owndns.exception.CategoryNotFoundException;
import com.onlinestore.owndns.model.Category;
import com.onlinestore.owndns.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**v1.1*
 * + findAllCategories
 */

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;


    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    public void deleteCategoryById(Long id) {
        categoryRepo.deleteById(id);
    }

    public Category editCategory(Category category) {
       return categoryRepo.save(category);
    }

    public Category findCategoryById(Long id) {
        return categoryRepo.findCategoryById(id).orElseThrow(
                ()-> new CategoryNotFoundException(getClass().getSimpleName() + " Category with id " + id + " not found!"));
    }

    public List<Category>findAllCategories() {
        return categoryRepo.findAll();
    }
}
