package com.ea.inzynierka.service;

import com.ea.inzynierka.exception.AuthorNotFound;
import com.ea.inzynierka.model.Author;
import java.util.List;

public interface AuthorService {

    Author create(Author author);

    Author delete(long id) throws AuthorNotFound;

    List<Author> findAll();
}
