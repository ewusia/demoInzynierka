package com.ea.inzynierka.web;

import com.ea.inzynierka.exception.BookNotFound;
import com.ea.inzynierka.model.Book;
import com.ea.inzynierka.repo.BookRepository;
import com.ea.inzynierka.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView bookListPage() {
        ModelAndView mav = new ModelAndView("list");
        List<Book> bookList = (List<Book>) bookRepository.findAll();
        mav.addObject("bookList", bookList);
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView newBookPage() {
        ModelAndView mav = new ModelAndView("addBookForm", "book", new Book());
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView createNewBook(@ModelAttribute @Valid Book book,
                                      BindingResult result,
                                      final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("addBookForm");
        }
        bookService.create(book);

        ModelAndView mav = new ModelAndView("redirect:/books/list");
        redirectAttributes.addFlashAttribute("successMessage", "Book '" + book.getTitle() + "' has been added successfully.");

        return mav;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable Integer id,
                                   final RedirectAttributes redirectAttributes) throws BookNotFound {

        Book book = bookService.delete(id);

        ModelAndView mav = new ModelAndView("redirect:/books/list");
        redirectAttributes.addFlashAttribute("successMessage", "Book '" + book.getTitle() + "' was successfully deleted.");

        return mav;
    }
}
