package com.ea.inzynierka.service;

import com.ea.inzynierka.model.Book;
import com.ea.inzynierka.repo.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
	
	@Resource
	private BookRepository bookRepository;

	@Override
	@Transactional
	public Book create(Book book) {
		Book createdBook = book;
		return bookRepository.save(createdBook);
	}

	@Override
	public List<Book> findAll() {
		return null;
	}

	@Override
	public Book findById(int id) {
		return null;
	}
	
	/*@Override
	@Transactional
	public Book findById(int id) {
		return bookRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=BookNotFound.class)
	public Book delete(int id) throws BookNotFound {
		Book deletedBook = bookRepository.findOne(id);
		
		if (deletedBook == null)
			throw new BookNotFound();
		
		bookRepository.delete(deletedBook);
		return deletedBook;
	}

	@Override
	@Transactional
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=BookNotFound.class)
	public Book update(Book book) throws BookNotFound {
		Book updatedBook = bookRepository.findOne(book.getId());
		
		if (updatedBook == null)
			throw new BookNotFound();
		
		updatedBook.setName(book.getName());
		updatedBook.setEmplNumber(book.getEmplNumber());
		return updatedBook;
	}*/

}
