package com.example.demo.web.dto;

import com.example.demo.constraint.FieldMatch;
import javax.validation.constraints.NotEmpty;

@FieldMatch.List({
        @FieldMatch(first = "title", second = "author", message = "The fields must match"),
        @FieldMatch(first = "cover", second = "category", message = "The fields fields must match")})

public class BookAdditionDto {

    @NotEmpty
    private String title;

    private Integer year;

    @NotEmpty
    private String author;

    @NotEmpty
    private String category;

    @NotEmpty
    private String cover;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

}
