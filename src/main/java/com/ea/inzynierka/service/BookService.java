package com.ea.inzynierka.service;
import com.ea.inzynierka.exception.BookNotFound;
import com.ea.inzynierka.model.Book;

public interface BookService {
	
	public Book create(Book book);
	public Book delete(int id) throws BookNotFound;
}
