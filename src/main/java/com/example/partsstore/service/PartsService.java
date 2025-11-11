package com.example.partsstore.service;

import com.example.partsstore.model.Part;
import com.example.partsstore.model.Category;
import java.util.*;
import java.util.stream.Collectors;

public class PartsService {
    private List<Part> allParts = new ArrayList<>();
    private List<Category> allCategories = new ArrayList<>();

    public PartsService() {
        // Здесь можно подгрузить данные из Supabase (пока что примеры статичные)

        allCategories.add(new Category("1", "Двигатель"));
        allCategories.add(new Category("2", "Тормоза"));

        allParts.add(new Part("1", "Болт", "Крепежный болт", 100.0, "1"));
        allParts.add(new Part("2", "Тормозные колодки", "Колодки передние", 1200.0, "2"));
        allParts.add(new Part("3", "Свечи", "Свечи зажигания", 300.0, "1"));
    }

    public List<Part> getAllParts() {
        return new ArrayList<>(allParts);
    }

    public List<Category> getAllCategories() {
        return allCategories;
    }

    public List<Part> getPartsFiltered(String categoryId, String searchQuery) {
        return allParts.stream()
                .filter(p -> (categoryId == null || categoryId.isEmpty() || p.getCategoryId().equals(categoryId)) &&
                        (searchQuery == null || searchQuery.isEmpty() ||
                                p.getName().toLowerCase().contains(searchQuery.toLowerCase())))
                .collect(Collectors.toList());
    }
}
