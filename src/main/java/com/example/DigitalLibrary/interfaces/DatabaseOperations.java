package com.example.DigitalLibrary.interfaces;

import com.example.DigitalLibrary.database.singletons.DatabaseConfig;

import java.util.List;
import java.util.Optional;

public abstract class DatabaseOperations<T> {

    protected DatabaseConfig connection = DatabaseConfig.getInstance();

    public abstract T createResgister(T data);
    public abstract Optional<T> findOneByName(String name);
    public abstract List<T> findAll();
    public abstract Optional<T> updateOne(T dataUpdated);
    public abstract Optional<T> deleteOne(String name);
}
