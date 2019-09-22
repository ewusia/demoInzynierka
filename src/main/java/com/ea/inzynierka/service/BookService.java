package com.ea.inzynierka.service;

import com.ea.inzynierka.exception.BookNotFound;
import com.ea.inzynierka.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {

    Book create(Book book);
    Book edit(Book book) throws BookNotFound;
    Book delete(long id) throws BookNotFound;
    List<Book> findAll();
}
