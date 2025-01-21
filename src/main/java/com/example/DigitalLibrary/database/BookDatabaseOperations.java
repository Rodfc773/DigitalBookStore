package com.example.DigitalLibrary.database;

import com.example.DigitalLibrary.Models.Book;
import com.example.DigitalLibrary.Services.BookQueryModelService;
import com.example.DigitalLibrary.database.singletons.DatabaseConfig;
import com.example.DigitalLibrary.interfaces.DatabaseOperations;
import com.example.DigitalLibrary.interfaces.QueryModel;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class BookDatabaseOperations extends DatabaseOperations<Book> {

    private final QueryModel SQLQueryConstructor = new BookQueryModelService();
    private final DatabaseConfig databaseConnection = DatabaseConfig.getInstance();

    @Override
    public Book createResgister(Book data) {

        String createQuery = SQLQueryConstructor.getCreateQuery();

        try{
            PreparedStatement ps = databaseConnection.getConnection().prepareStatement(createQuery);

            ps.setString(1,data.getBookName());
            ps.setString(2, data.getAuthorName());
            ps.setString(3, data.getPublished());
            ps.setInt(4, data.getNumberOfPages());
            ps.setInt(5, 0);
            ps.setDate(6, Date.valueOf(LocalDate.now()));

            ps.executeUpdate();

            return data;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir as informações no banco de dados");
        }
    }

    @Override
    public Optional<Book> findOneByName(String title) {
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }

    @Override
    public Optional<Book> updateOne(Book dataUpdated) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> deleteOne(String name) {
        return Optional.empty();
    }
}
