package com.ea.inzynierka.service;
import com.ea.inzynierka.exception.BookNotFound;
import com.ea.inzynierka.model.Book;

import java.util.List;

public interface BookService {
	
	public Book create(Book shop);
	public Book delete(int id) throws BookNotFound;
	public List<Book> findAll();
	public Book update(Book book) throws BookNotFound;
	public Book findById(int id);

}
