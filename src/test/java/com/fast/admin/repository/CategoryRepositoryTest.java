package com.fast.admin.repository;

import com.fast.admin.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create() {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createAt = LocalDateTime.now();
        String createBy = "ADMIN";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createAt);
        category.setCreatedBy(createBy);

        Category newCategory = categoryRepository.save(category);
    }

    @Test
    public void read() {
        Optional<Category> category = categoryRepository.findByType("COMPUTER");
        category.ifPresent(selectCategory-> {
            System.out.println(selectCategory);
        });
    }
}
