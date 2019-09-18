package com.ea.inzynierka.repo;

import com.ea.inzynierka.model.Author;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByName(String name);
    Author findById(int id);

}
