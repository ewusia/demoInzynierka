package com.example.demo;

import com.ea.inzynierka.Application;
import com.ea.inzynierka.exception.AuthorNotFound;
import com.ea.inzynierka.exception.BookNotFound;
import com.ea.inzynierka.exception.CategoryNotFound;
import com.ea.inzynierka.model.Author;
import com.ea.inzynierka.model.Book;
import com.ea.inzynierka.model.Category;
import com.ea.inzynierka.repo.AuthorRepository;
import com.ea.inzynierka.repo.BookRepository;
import com.ea.inzynierka.repo.CategoryRepository;
import com.ea.inzynierka.service.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class DemoApplicationTests {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookService bookService;

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
	//@Ignore
	@Test
	public void testFindBookById()
	{
		Optional<Book> book = Optional.ofNullable(bookService.findById(-1));
		Assert.assertEquals("Java. Podstawy", book.get().getTitle());
		Assert.assertEquals("IT", book.get().getCategory().getName());
		Assert.assertEquals("hard-cover", book.get().getCover());
		Assert.assertEquals("2019", book.get().getYear());
		Assert.assertEquals("Cay S. Horstmann", book.get().getAuthors().stream().findFirst().get().getName());
		return;
	}
	//@Ignore
	@Test
	//@Rollback(false)
	public void testAddBook()
	{
		Category category = new Category();
		category.setName("History");
		categoryService.save(category);
		Long idc = category.getId();
		Assert.assertNotNull(idc);
		Optional<Category> newCategory = categoryService.findById(idc);

		Assert.assertEquals("History", newCategory.get().getName());

		Author author = new Author();
		author.setName("Norman Davies");
		authorService.save(author);
		Long ida = author.getId();
		Assert.assertNotNull(ida);
		Optional<Author> newAuthor = authorService.findById(ida);

		Assert.assertEquals("Norman Davies", newAuthor.get().getName());

		Set authors = new HashSet();
		authors.add(author);

		Book book = new Book();
		book.setTitle("Historia Świata");
		book.setYear("2008");
		book.setCover("hard-cover");
		book.setCategory(category);
		book.setAuthors(authors);
		bookService.save(book);

		Long idb = book.getId();
		Assert.assertNotNull(idb);
		Optional<Book> newBook = Optional.ofNullable(bookService.findById(idb));

		Assert.assertEquals("Historia Świata", newBook.get().getTitle());
		Assert.assertEquals("2008", newBook.get().getYear());
		Assert.assertEquals("hard-cover", newBook.get().getCover());
		Assert.assertEquals("History", newBook.get().getCategory().getName());
		Assert.assertEquals("Norman Davies", newBook.get().getAuthors().stream().findFirst().get().getName());
		return;
	}
	@Test
	public void testRemoveBook() throws BookNotFound {
		long startingNumberOfBook = bookService.count();
		Category category = new Category();
		category.setName("History");
		categoryService.save(category);
		Long idc = category.getId();
		Assert.assertNotNull(idc);
		Optional<Category> newCategory = categoryService.findById(idc);

		Assert.assertEquals("History", newCategory.get().getName());

		Author author = new Author();
		author.setName("Norman Davies");
		authorService.save(author);
		Long ida = author.getId();
		Assert.assertNotNull(ida);
		Optional<Author> newAuthor = authorService.findById(ida);

		Assert.assertEquals("Norman Davies", newAuthor.get().getName());

		Set authors = new HashSet();
		authors.add(author);

		Book book = new Book();
		book.setTitle("Historia Świata");
		book.setYear("2008");
		book.setCover("hard-cover");
		book.setCategory(category);
		book.setAuthors(authors);
		bookService.save(book);

		Long idb = book.getId();
		Assert.assertNotNull(idb);
		Assert.assertEquals(6, startingNumberOfBook+1);

		bookService.delete(idb);
		Assert.assertEquals(5, startingNumberOfBook);
	}
}
