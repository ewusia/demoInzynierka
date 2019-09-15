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
		return bookRepository.save(createdBook);
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

	@Override
	@Transactional(rollbackFor= BookNotFound.class)
	public Book update(Book book) throws BookNotFound {
		Book updatedBook = bookRepository.findById(book.getId());

		if (updatedBook == null)
			throw new BookNotFound();

		updatedBook.setTitle(book.getTitle());
		updatedBook.setAuthor(book.getAuthor());
		return updatedBook;
	}

	@Override
	public List<Book> findAll() {
		return null;
	}

	@Override
	public Book findById(int id) {
		return null;
	}

}
