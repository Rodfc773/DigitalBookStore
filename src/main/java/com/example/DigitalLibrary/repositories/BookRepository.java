package com.example.DigitalLibrary.repositories;

import com.example.DigitalLibrary.Models.Book;
import com.example.DigitalLibrary.database.BookDatabaseOperations;
import com.example.DigitalLibrary.interfaces.Repository;

import java.util.List;

public class BookRepository implements Repository<Book> {

    private BookDatabaseOperations bookOperations = new BookDatabaseOperations();

    public BookRepository(){}

    @Override
    public Book create(Book newBook) {

        try{
            Book createdBook = this.bookOperations.createResgister(newBook);
            return createdBook;
        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public Book update() {
        return null;
    }

    @Override
    public Book delete() {
        return null;
    }

    @Override
    public List<Book> showAll() {
        return List.of();
    }

    @Override
    public Book showOne() {
        return null;
    }
}
