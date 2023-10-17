package com.example.tempbe.domain.category.service;

import com.example.tempbe.domain.category.domain.Category;
import com.example.tempbe.domain.category.domain.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
