package com.example.demo;

import com.ea.inzynierka.Application;
import com.ea.inzynierka.exception.AuthorNotFound;
import com.ea.inzynierka.exception.CategoryNotFound;
import com.ea.inzynierka.model.Author;
import com.ea.inzynierka.model.Book;
import com.ea.inzynierka.model.Category;
import com.ea.inzynierka.repo.AuthorRepository;
import com.ea.inzynierka.repo.BookRepository;
import com.ea.inzynierka.repo.CategoryRepository;
import com.ea.inzynierka.service.AuthorService;
import com.ea.inzynierka.service.AuthorServiceImpl;
import com.ea.inzynierka.service.BookServiceImpl;
import com.ea.inzynierka.service.CategoryService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class DemoApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookServiceImpl bookServiceImpl;

	@Test
	public void contextLoads() {
	}
	@Test
	public void testFindCategoryById()
	{
		Optional<Category> category = categoryService.findById(-1);
		Assert.assertEquals("IT", category.get().getName());
		return;
	}
	@Test
	//@Rollback(false)
	public void testAddCategory()
	{
		Category category = new Category();
		category.setName("History");
		categoryService.save(category);
		Long id = category.getId();
		Assert.assertNotNull(id);
		Optional<Category> newCategory = categoryService.findById(id);

		Assert.assertEquals("History", newCategory.get().getName());
		return;
	}
	@Test
	public void testRemoveCategory() throws CategoryNotFound {
		long startingNumberOfCategory = categoryService.count();
		Category category = new Category();
		category.setName("Criminal");
		categoryService.save(category);
		Long id = category.getId();
		Assert.assertNotNull(id);
		Optional<Category> newCategory = categoryService.findById(id);

		Assert.assertEquals("Criminal", newCategory.get().getName());
		Assert.assertEquals(4, startingNumberOfCategory+1);

		categoryService.delete(id);
		Assert.assertEquals(3, startingNumberOfCategory);
	}
	@Test
	public void testFindAuthorById()
	{
		Optional<Author> author = authorService.findById(-1);
		Assert.assertEquals("Cay S. Horstmann", author.get().getName());
		return;
	}
	@Test
	//@Rollback(false)
	public void testAddAuthor()
	{
		Author author = new Author();
		author.setName("Norman Davies");
		authorService.save(author);
		Long id = author.getId();
		Assert.assertNotNull(id);
		Optional<Author> newAuthor = authorService.findById(id);

		Assert.assertEquals("Norman Davies", newAuthor.get().getName());
		return;
	}
	@Test
	public void testRemoveAuthor() throws AuthorNotFound {
		long startingNumberOfAuthor = authorService.count();
		Author author = new Author();
		author.setName("Agatha Christie");
		authorService.save(author);
		Long id = author.getId();
		Assert.assertNotNull(id);
		Optional<Author> newAuthor = authorService.findById(id);

		Assert.assertEquals("Agatha Christie", newAuthor.get().getName());
		Assert.assertEquals(6, startingNumberOfAuthor+1);

		authorService.delete(id);
		Assert.assertEquals(5, startingNumberOfAuthor);
	}
	@Ignore
	@Test
	public void testFindBookById()
	{
		Optional<Book> book = bookRepository.findById((long) -1);
		Assert.assertEquals("Java. Podstawy", book.get().getTitle());
		Assert.assertEquals("IT", book.get().getCategory().getName());
		Assert.assertEquals("hard-cover", book.get().getCover());
		Assert.assertEquals("2019", book.get().getYear());
		Assert.assertEquals("Cay S. Horstmann", book.get().getAuthors().stream().findFirst().get().getName());
		return;
	}
}
