package com.ea.inzynierka.repo;

import com.ea.inzynierka.model.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
}
