package com.gpch.login.service;

import com.mykong.form.model.Book;

import java.util.List;

public interface BookService {

	Book findById(Integer id);
	
	List<Book> findAll();

	void saveOrUpdate(Book book);
	
	void delete(int id);
	
}