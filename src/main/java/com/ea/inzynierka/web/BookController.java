package com.ea.inzynierka.web;

import com.ea.inzynierka.repo.BookRepository;
import com.ea.inzynierka.model.Book;
import com.ea.inzynierka.web.exception.BookIdMismatchException;
import com.ea.inzynierka.web.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView bookListPage() {
        ModelAndView mav = new ModelAndView("list");
        List<Book> bookList = (List<Book>) bookRepository.findAll();
        mav.addObject("bookList", bookList);

        ArrayList<String> authors = new ArrayList<>();
        authors.add("adam");
        authors.add("ewa");


        mav.addObject("authors",authors);
        mav.addObject("selectedAuthor", "");
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView newBookPage() {
        ModelAndView mav = new ModelAndView("addBooksForm", "book", new Book());
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView createNewBook(@ModelAttribute @Valid Book book,
                                      BindingResult result,
                                      final RedirectAttributes redirectAttributes) {

        if (result.hasErrors())
            return new ModelAndView("addBooksForm");

        ModelAndView mav = new ModelAndView();
        String message = "New book " + book.getTitle() + " was successfully created.";

        //bookRepository.create(book);
        mav.setViewName("redirect:/index.html");

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

/*    @RequestMapping(value = "/addition", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Book book, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        bookRepository.saveOrUpdate(book);
        modelAndView.addObject("successMessage", "Book has been added successfully");
        modelAndView.addObject("book", new Book());
        modelAndView.setViewName("addition");
        return modelAndView;
    }*/

    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable long id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        Book book1 = bookRepository.save(book);
        return book1;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable long id) {
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }
}
