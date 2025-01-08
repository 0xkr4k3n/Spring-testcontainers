package com.testing.springtestcontainers.controllers;

import com.testing.springtestcontainers.entities.Category;
import com.testing.springtestcontainers.repositories.CategoryRepository;
import com.testing.springtestcontainers.testingInfra.ApplicationIntegrationTests;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class CategoryControllerTest extends ApplicationIntegrationTests {
    private static final String CATEGORY_ENDPOINT="/categories";
   @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void TestGetAllCategories_ShouldReturnOk() throws Exception {

        List<Category> categories = List.of(
                new Category("Electronics", "All kinds of electronic gadgets from smartphones to laptops"),
                new Category("Books", "A wide range of books from novels to educational textbooks")
        );
        categoryRepository.saveAll(categories);
        MvcResult mvcResult=mockMvc.perform(
                get(CATEGORY_ENDPOINT).
                        contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn();
        var response=mvcResult.getResponse().getContentAsString();
        assertNotNull(response);
        assertFalse(response.isEmpty());
        System.out.println(response);
    }
}
