package com.ea.inzynierka.service;

import com.ea.inzynierka.exception.AuthorNotFound;
import com.ea.inzynierka.model.Author;
import com.ea.inzynierka.repo.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Resource
	private AuthorRepository authorRepository;

	@Override
	@Transactional
	public Author create(Author author) {
		Author createdAuthor = author;
		authorRepository.save(createdAuthor);
		return createdAuthor;
	}

	@Override
	@Transactional(rollbackFor=AuthorNotFound.class)
	public Author delete(int id) throws AuthorNotFound {
		Author deletedAuthor = authorRepository.findById(id);

		if (deletedAuthor == null)
			throw new AuthorNotFound();

		authorRepository.delete(deletedAuthor);
		return deletedAuthor;
	}

}
