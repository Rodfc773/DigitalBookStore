package com.example.DigitalLibrary.database;

import com.example.DigitalLibrary.Models.Book;
import com.example.DigitalLibrary.Services.BookQueryModelService;
import com.example.DigitalLibrary.database.singletons.DatabaseConfig;
import com.example.DigitalLibrary.interfaces.DatabaseOperations;
import com.example.DigitalLibrary.interfaces.QueryModel;

import java.lang.reflect.Field;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class BookDatabaseOperations extends DatabaseOperations<Book> {

    private final QueryModel SQLQueryConstructor = new BookQueryModelService();
    private final DatabaseConfig databaseConnection = DatabaseConfig.getInstance();
    
    public BookDatabaseOperations(){}
    @Override
    public Book createResgister(Book data) {
        String createQuery = SQLQueryConstructor.getCreateQuery();

        try {

            Connection conn = databaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, data.getBookName());
            ps.setString(2, data.getAuthorName());
            ps.setDate(3,Date.valueOf(data.dateConversion()));
            ps.setInt(4, data.getNumberOfPages());
            ps.setInt(5, 0);
            ps.setDate(6, Date.valueOf(LocalDate.now()));

            int affectedRows = ps.executeUpdate(); // Executa o INSERT
            if (affectedRows == 0) {
                throw new SQLException("A inserção falhou, nenhuma linha foi afetada.");
            }

            // Obtém o ID gerado automaticamente (caso exista)
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                data.setId(generatedKeys.getInt(1)); // Supondo que ID seja um inteiro
            } else {
                throw new SQLException("Falha ao obter o ID gerado.");
            }

            return data;  // Retorna o objeto com o ID atualizado
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir as informações no banco de dados", e);
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

            Set<Object> kValues = new HashSet<>(fieldsToBeUpdated.values());

            List<Object> values = Arrays.asList(kValues.toArray());

            for (int i = 0; i < values.size(); i++) {
                ps.setObject(i + 1, values.indexOf(i));
            }


            ResultSet resultOperation = ps.executeQuery();

            while (resultOperation.next()){
                dataUpdated.setCreatedAt(resultOperation.getDate("created_at"));
            }

            return Optional.of(dataUpdated);

        } catch (Exception e){
            throw new RuntimeException("Algo deu errado no update do registro");
        }
    }

    @Override
    public Optional<Book> deleteOne(String name) {

        Connection conn = databaseConnection.getConnection();
        String deleteQuery = SQLQueryConstructor.getDeleteQuery();

        try{
            PreparedStatement ps = conn.prepareStatement(deleteQuery);

            ResultSet result = ps.executeQuery();

            Book deletdBook = new Book();

            while (result.next()){
                deletdBook.setBookName(result.getString("title"));
                deletdBook.setAuthorName(result.getString("author"));
                deletdBook.setId(result.getInt("id"));
                deletdBook.setNumberOfPages(result.getInt("pages"));
                deletdBook.setPublished(result.getDate("publish_date").toString());
                deletdBook.setHolderId(result.getInt("renterID"));
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
