package com.ea.inzynierka.service;

import com.ea.inzynierka.exception.CategoryNotFound;
import com.ea.inzynierka.model.Category;

import java.util.List;

public interface CategoryService {

    Category create(Category category);

    Category delete(long id) throws CategoryNotFound;

    List<Category> findAll();

}
