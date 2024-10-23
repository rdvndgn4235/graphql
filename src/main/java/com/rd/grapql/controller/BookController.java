package com.rd.grapql.controller;


import com.rd.grapql.model.Book;
import com.rd.grapql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Tüm kitapları sorgula
    @QueryMapping
    public List<Book> books() {
        return bookService.getAllBooks();
    }

    // ID ile kitap sorgula
    @QueryMapping
    public Optional<Book> bookById(@Argument String id) {
        return bookService.getBookById(id);
    }

    // Yeni kitap ekle
    @MutationMapping
    public Book addBook(@Argument String title, @Argument String author) {
        return bookService.addBook(title, author);
    }

    // kitap sil
    @MutationMapping
    public Book deleteBook(@Argument String id) {
        return bookService.deleteBook(id);
    }

    // kitap güncelle
    @MutationMapping
    public Book updateBook(@Argument String id, @Argument String title, @Argument String author) {
        return bookService.updateBook(id, title, author);
    }
}

