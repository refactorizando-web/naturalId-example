package com.refactorizando.example.naturaId.controller;

import com.refactorizando.example.naturaId.entity.Book;
import com.refactorizando.example.naturaId.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class BookController {

  private final BookRepository bookRepository;

  @GetMapping("/books/{naturalId}")
  public ResponseEntity<Book> getBookByNaturalId(@PathVariable String naturalId) {

    return ResponseEntity.ok((Book)bookRepository.findBySimpleNaturalId(naturalId).orElseThrow());
  }

  @PostMapping("/books")
  public ResponseEntity<Book> saveBook(@RequestBody Book book) {

    var save = bookRepository.save(book);

    return new ResponseEntity<>(HttpStatus.CREATED);

  }
}
