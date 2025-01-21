package com.example.DigitalLibrary.interfaces;

import com.example.DigitalLibrary.Models.Book;

import java.util.List;

public interface Repository <T>{

    public T create(T entity);
    public T update();
    public T delete();
    public List<T> showAll();
    public T showOne();
}
