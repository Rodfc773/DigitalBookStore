package com.example.DigitalLibrary.Services;

import com.example.DigitalLibrary.interfaces.QueryModel;

import java.util.Map;

public class BookQueryModelService implements QueryModel {
    @Override
    public String getCreateQuery() {
        return "INSERT INTO Books (title, author, publish_date, pages, renterID, created_at) VALUES (? , ?, ? ,? ,?, ?)";
    }

    @Override
    public String getSearchOneQuery() {
        return "SELECT * FROM Books WHERE title = ?";
    }

    @Override
    public String getSearchAllQuery() {
        return "SELECT * FROM Books";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE * FROM Books WHERE title = ?";
    }

    @Override
    public String getUpdateObeQuery(Map<String, Object> fields) {

        StringBuilder queryBuilder = new StringBuilder("UPDATE")
                .append("Books").append("SET");

        for (String field : fields.keySet()){
            queryBuilder.append(field).append("=?,");
        }

        queryBuilder.deleteCharAt(queryBuilder.length()-1);

        queryBuilder.append("WHERE title = ?");

        return queryBuilder.toString();
    }
}
