package com.gpch.login.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;

    @Column(name = "title")
    @NotEmpty(message = "*Please write a title")
    private String title;

    @Column(name = "year")
    @NotEmpty(message = "*Please write a year")
    private String year;

    @Column(name = "category")
    @NotEmpty(message = "*Please write a category")
    private String category;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_role", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
