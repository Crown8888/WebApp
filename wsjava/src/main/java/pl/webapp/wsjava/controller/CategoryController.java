package pl.webapp.wsjava.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.webapp.wsjava.dto.CategoryDTO;
import pl.webapp.wsjava.service.CategoryService;
import pl.webapp.wsjava.service.Mapper;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/categories")

public class CategoryController {

    private final CategoryService categoryService;
    private final Mapper modelMapper;

    public CategoryController(CategoryService categoryService, Mapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }
    //get all categories
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAll().stream()
                .map(modelMapper::toDTO)
                .collect(Collectors.toList()));
    }
}
