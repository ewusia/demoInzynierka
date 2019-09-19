package com.ea.inzynierka.service;

import com.ea.inzynierka.exception.BookNotFound;
import com.ea.inzynierka.model.Book;
import com.ea.inzynierka.repo.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookRepository bookRepository;

    @Override
    @Transactional
    public Book create(Book book) {
        Book createdBook = book;
        bookRepository.save(createdBook);
        return createdBook;
    }

    @Override
    @Transactional(rollbackFor = BookNotFound.class)
    public Book delete(long id) throws BookNotFound {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book book = bookOptional.orElseThrow(BookNotFound::new);

        bookRepository.delete(book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> result = new ArrayList<Book>();
        Iterable<Book> all = bookRepository.findAll();
        all.forEach(result::add);

        return result;
    }

}
