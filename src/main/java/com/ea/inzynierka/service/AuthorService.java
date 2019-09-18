package com.ea.inzynierka.service;
import com.ea.inzynierka.exception.AuthorNotFound;
import com.ea.inzynierka.model.Author;

public interface AuthorService {
	
	public Author create(Author author);
	public Author delete(int id) throws AuthorNotFound;
}
