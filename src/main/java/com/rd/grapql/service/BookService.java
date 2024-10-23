package com.rd.grapql.service;

import com.rd.grapql.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    // Constructor, başlangıç kitaplarını ekleyelim
    public BookService() {
        books.add(new Book(UUID.randomUUID().toString(), "The Hobbit", "J.R.R. Tolkien"));
        books.add(new Book(UUID.randomUUID().toString(), "Harry Potter", "J.K. Rowling"));
    }

    // Tüm kitapları getir
    public List<Book> getAllBooks() {
        return books;
    }

    // ID ile kitap bul
    public Optional<Book> getBookById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    // Yeni kitap ekle
    public Book addBook(String title, String author) {
        Book book = new Book(UUID.randomUUID().toString(), title, author);
        books.add(book);
        return book;
    }

    // listeden kitap sil
    public Book deleteBook(String id) {
        Optional<Book> book = getBookById(id);
        book.ifPresent(books::remove);
        return book.orElse(null);
    }

    // kitap güncelle
    public Book updateBook(String id, String title, String author) {
        Optional<Book> book = getBookById(id);
        book.ifPresent(value -> value.setTitle(title));
        book.ifPresent(value -> value.setAuthor(author));
        return book.orElse(null);
    }
}
