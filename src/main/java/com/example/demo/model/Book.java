package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int year;
    private String cover;
    
    @Transient
    private String view;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PUBLISHER_ID")
    private Publisher publisher; // publisher_id
    
/*    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(
                    name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "author_id", referencedColumnName = "id"))
    private Collection<Author> authors;*/

/*    public Book() {
    }

    public Book(String title, int year, String cover) {
        this.title = title;
        this.year = year;
        this.cover = cover;
    }

    public Book(String title, int year, String cover, Collection<Author> authors) {
        this.title = title;
        this.year = year;
        this.cover = cover;
        this.authors = authors;
    }*/

    public Book(Long id, String title, int year, String cover, Publisher servedIn) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.cover = cover;
        this.view = "";
        this.publisher = servedIn;
    }

    public Book(Long id, String title, int year, String cover, String view, Publisher servedIn) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.cover = cover;
        this.view = view;
        this.publisher = servedIn;
    }

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", cover='" + cover + '\'' +
                ", authors=" + authors +
                '}';
    }*/
    public Book(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", cover='" + cover + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
