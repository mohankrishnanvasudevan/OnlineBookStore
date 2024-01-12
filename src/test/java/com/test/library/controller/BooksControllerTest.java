package com.test.library.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Replace "valid-api-key" with an actual valid API key for testing
    private final String validApiKey = "7b1e6363-b369-4d29-86ba-2c2d26a3f6b4";

    // Replace with actual book request JSON for testing
    private final String validBookRequestJson = "{\"title\":\"Silent Patient\",\"publicationDate\":\"2024-01-09T03:30:07.502Z\",\"isbn\":\"978-0-987654-32-1\",\"genre\":\"crime\",\"otherBookDetails\":\"mystry thriller\"}";

    // Replace with actual review request JSON for testing
    private final String validReviewRequestJson = "{\"rating\":4,\"comments\":\"Awesome\",\"reviewDate\":\"2024-01-09T03:35:35.352Z\",\"userName\":\"krishna\"}";

    // Replace with actual author ID for testing
    private final int validAuthorId = 3;

    @Test
    void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/api/books")
               .header("x-api-key", validApiKey))
               .andExpect(status().isOk());
    }

    @Test
    void testCreateBook() throws Exception {
        mockMvc.perform(post("/api/books")
               .header("x-api-key", validApiKey)
               .content(validBookRequestJson)
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }

    @Test
    void testGetBookByISBN() throws Exception {
        mockMvc.perform(get("/api/books/{isbn}", "978-0-987654-32-1")
               .header("x-api-key", validApiKey))
               .andExpect(status().isOk());
    }

    @Test
    void testUpdateBookByISBN() throws Exception {
        mockMvc.perform(put("/api/books/{isbn}", "978-0-987654-32-1")
               .header("x-api-key", validApiKey)
               .param("title", "Updated Title")
               .param("publicationDate", "2023-01-01")
               .param("genre", "Updated Genre")
               .param("otherBookDetails", "Updated Details"))
               .andExpect(status().isOk());
    }

    @Test
    void testDeleteBookByISBN() throws Exception {
        mockMvc.perform(delete("/api/books/{isbn}", "978-0-543210-98-7")
               .header("x-api-key", validApiKey))
               .andExpect(status().isOk());
    }

    @Test
    void testAddReviewByISBN() throws Exception {
        mockMvc.perform(post("/api/books/{isbn}/reviews", "978-0-987654-32-1")
               .header("x-api-key", validApiKey)
               .content(validReviewRequestJson)
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }

    @Test
    void testGetAuthorByAuthorId() throws Exception {
        mockMvc.perform(get("/api/authors/{authorId}", validAuthorId)
               .header("x-api-key", validApiKey))
               .andExpect(status().isOk());
    }
}
