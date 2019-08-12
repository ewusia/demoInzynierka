package com.example.demo.web.controller;

import javax.validation.Valid;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.web.dto.BookAdditionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addition")
public class BookAdditionController {

    //@Autowired
    private BookService bookService;

    @ModelAttribute("book")
    public BookAdditionDto bookAdditionDto() {
        return new BookAdditionDto();
    }

    @GetMapping
    public String showAdditionForm(Model model) {
        return "addition";
    }

    @PostMapping
    public String addBookAccount(@ModelAttribute("book") @Valid BookAdditionDto bookDto,
                                      BindingResult result){

        Book existing = bookService.findByTitle(bookDto.getTitle());
        if (existing != null){
            result.rejectValue("title", null, "There is already a book added with that title");
        }

        if (result.hasErrors()){
            return "addition";
        }

        bookService.save(bookDto);
        return "redirect:/addition?success";
    }

}
