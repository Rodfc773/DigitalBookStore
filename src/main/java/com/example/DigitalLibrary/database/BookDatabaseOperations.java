package com.example.DigitalLibrary.database;

import com.example.DigitalLibrary.Models.Book;
import com.example.DigitalLibrary.Services.BookQueryModelService;
import com.example.DigitalLibrary.database.singletons.DatabaseConfig;
import com.example.DigitalLibrary.interfaces.DatabaseOperations;
import com.example.DigitalLibrary.interfaces.QueryModel;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.*;

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

        String query = SQLQueryConstructor.getSearchOneQuery();

        try {

            PreparedStatement ps = databaseConnection.getConnection().prepareStatement(query);

            ps.setString(1, title);

            ResultSet resultSearch = ps.executeQuery();

            if (!resultSearch.next()) return Optional.empty();

            Book foundBook = new Book();

            foundBook.setId(resultSearch.getInt("id"));
            foundBook.setBookName(resultSearch.getString("title"));
            foundBook.setAuthorName(resultSearch.getString("author"));
            foundBook.setNumberOfPages(resultSearch.getInt("pages"));
            foundBook.setHolderId(resultSearch.getInt("renterID"));
            foundBook.setPublished(resultSearch.getDate("publish_date").toString());
            foundBook.setCreatedAt(resultSearch.getDate("created_at"));

            return Optional.of(foundBook);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> findAll() {
        List<Book> allBooksFound = new ArrayList<>();

        String query = SQLQueryConstructor.getSearchAllQuery();

        try{
            PreparedStatement ps = databaseConnection.getConnection().prepareStatement(query);

            ResultSet resultSearch = ps.executeQuery();

            if(!resultSearch.next()) return allBooksFound;

            while(resultSearch.next()){

                Book foundBook = new Book();

                foundBook.setId(resultSearch.getInt("id"));
                foundBook.setBookName(resultSearch.getString("title"));
                foundBook.setAuthorName(resultSearch.getString("author"));
                foundBook.setNumberOfPages(resultSearch.getInt("pages"));
                foundBook.setHolderId(resultSearch.getInt("renterID"));
                foundBook.setPublished(resultSearch.getDate("publish_date").toString());
                foundBook.setCreatedAt(resultSearch.getDate("created_at"));

                allBooksFound.add(foundBook);
            }
            return  allBooksFound;
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao tentar buscar os livros");
        }

    }
    @Override
    public Optional<Book> updateOne(Book dataUpdated, int id) {

        Connection conn = databaseConnection.getConnection();
        Map<String, Object> fieldsToBeUpdated = new HashMap<>();

        Class<?> clazz = dataUpdated.getClass();

        Field[] fields = clazz.getFields();

        for(Field field: fields){

            field.setAccessible(true);

            try {

                if(field.get(dataUpdated) == null) continue;

                fieldsToBeUpdated.put(field.getName(), field.get(dataUpdated));
            } catch (Exception e) {
                System.out.println("Deu algo de errado na conversão dos dados para o Map");
                e.printStackTrace();
            }
        }
        try{

            String query = SQLQueryConstructor.getUpdateObeQuery(fieldsToBeUpdated);

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet resultOperation = ps.executeQuery();


            return Optional.of(dataUpdated);

        } catch (Exception e){
            throw new RuntimeException("Algo deu errado no update do registro");
        }
    }

    @Override
    public Optional<Book> deleteOne(String name) {
        return Optional.empty();
    }
}
