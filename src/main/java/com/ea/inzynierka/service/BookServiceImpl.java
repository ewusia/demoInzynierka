package com.ea.inzynierka.service;

import com.ea.inzynierka.exception.BookNotFound;
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
		bookRepository.save(createdBook);
		return createdBook;
	}

	@Override
	@Transactional(rollbackFor=BookNotFound.class)
	public Book delete(int id) throws BookNotFound {
		Book deletedBook = bookRepository.findById(id);

		if (deletedBook == null)
			throw new BookNotFound();

		bookRepository.delete(deletedBook);
		return deletedBook;
	}

}
