package com.example.DigitalLibrary.Services;

import com.example.DigitalLibrary.interfaces.QueryModel;

import java.util.Map;

public class HolderQueryModelService implements QueryModel {
    @Override
    public String getCreateQuery() {
        return "INSERT into Holders (firstname, lastname, age, id_number, email) VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getSearchOneQuery() {
        return "SELECT id, firstname, lastname, age, email FROM Holders WHERE email=?";
    }

    @Override
    public String getSearchAllQuery() {
        return "SELECT id, firstname, lastname, age, email FROM Holders";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Holders WHERE email=? ";
    }

    @Override
    public String getUpdateObeQuery(Map<String, Object> fieldsToBeUpdated) {
        StringBuilder queryBuilder = new StringBuilder("UPDATE");

        queryBuilder.append("Holders").append("SET");

        for (String key : fieldsToBeUpdated.keySet()){
            queryBuilder.append(key).append(" = ?,");
        }

        queryBuilder.deleteCharAt(queryBuilder.length()-1);

        queryBuilder.append("WHERE id = ?");
        return queryBuilder.toString();
    }
}
