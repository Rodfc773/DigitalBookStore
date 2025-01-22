package com.example.DigitalLibrary.repositories;

import com.example.DigitalLibrary.Models.Holder;
import com.example.DigitalLibrary.database.singletons.DatabaseConfig;
import com.example.DigitalLibrary.interfaces.Repository;

import java.util.List;

public class HolderRepository implements Repository<Holder> {

    private DatabaseConfig databaseConnection = DatabaseConfig.getInstance();
    @Override
    public Holder create(Holder newHolder) {
        return null;
    }

    @Override
    public Holder update() {
        return null;
    }

    @Override
    public Holder delete() {
        return null;
    }

    @Override
    public List<Holder> showAll() {
        return List.of();
    }

    @Override
    public Holder showOne() {
        return null;
    }
}
