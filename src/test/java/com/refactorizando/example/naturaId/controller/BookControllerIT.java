package com.refactorizando.example.naturaId.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.refactorizando.example.naturaId.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MimeTypeUtils;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void finbBookByNaturalId() throws Exception {
    var book = createBook();

    mockMvc.perform(
            MockMvcRequestBuilders.post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
        .andExpect(status().isCreated());

    var findByNaturalId = mockMvc.perform(
            get("/api/books/1A2s-3f").accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andReturn();

    var b = objectMapper.readValue(findByNaturalId.getResponse().getContentAsString(), Book.class);

    assert b.getIsbn().equalsIgnoreCase("1A2s-3f");


  }

  private Book createBook() {

    Book book = new Book();
    book.setIsbn("1A2s-3f");
    book.setTitle("The Count of Monte Cristo");
    book.setPrice(34);

    return book;

  }
}
