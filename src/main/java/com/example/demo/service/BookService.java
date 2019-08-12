package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.web.dto.BookAdditionDto;

public interface BookService {

    Book findByTitle(String title);

    Book save(BookAdditionDto addition);
}
