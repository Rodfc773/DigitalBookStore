package com.example.DigitalLibrary.repositories;

import com.example.DigitalLibrary.Models.Book;
import com.example.DigitalLibrary.Services.BookQueryModelService;
import com.example.DigitalLibrary.interfaces.QueryModel;
import com.example.DigitalLibrary.interfaces.Repository;

import java.util.List;

public class BookRepository implements Repository<Book> {

    private QueryModel booksQuery = new BookQueryModelService();

    @Override
    public Book create(Book newBook) {

        String SQLQuery = booksQuery.getCreateQuery();
        return null;
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
