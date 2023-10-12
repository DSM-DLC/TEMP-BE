package com.example.tempbe.domain.category.controller;

import com.example.tempbe.domain.category.domain.Category;
import com.example.tempbe.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/department")
    public List<Category> getCategory(){
        return categoryService.findAll();
    }
}
