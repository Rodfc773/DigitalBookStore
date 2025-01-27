package com.example.DigitalLibrary.database;


import com.example.DigitalLibrary.Models.Holder;
import com.example.DigitalLibrary.interfaces.DatabaseOperations;

import java.util.List;
import java.util.Optional;

public class HolderDatabaseOperations extends DatabaseOperations<Holder> {
    @Override
    public Holder createResgister(Holder newHolder) {
        return null;
    }

    @Override
    public Optional<Holder> findOneByName(String email) {
        return Optional.empty();
    }

    @Override
    public List<Holder> findAll() {
        return List.of();
    }

    @Override
    public Optional<Holder> updateOne(Holder updatedData, int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Holder> deleteOne(String name) {
        return Optional.empty();
    }
}
