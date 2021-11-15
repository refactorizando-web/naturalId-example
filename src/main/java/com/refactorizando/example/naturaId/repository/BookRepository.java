package com.refactorizando.example.naturaId.repository;

import com.refactorizando.example.naturaId.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository<T, ID> extends NaturalRepository<Book, Long> {

}