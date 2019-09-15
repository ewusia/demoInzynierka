package com.ea.inzynierka.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "title field cannot be empty")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "author field cannot be empty")
    private String author;

    @Column(nullable = false)
    @NotBlank(message = "year field cannot be empty")
    @Pattern(regexp = "^\\d{4}$", message = "required format 'YYYY'")
    @Min(1901)
    private String year;

    @Column(nullable = false)
    @NotBlank(message = "category field cannot be empty")
    private String category;

    @Column(nullable = false)
    @NotBlank(message = "cover field cannot be empty")
    private String cover;

    public Book() {
        super();
    }

    public Book(String title, String author) {
        super();
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, String year, String category, String cover) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.category = category;
        this.cover = cover;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (id != other.id)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", category=" + category + ", cover=" + cover + "]";
    }

}