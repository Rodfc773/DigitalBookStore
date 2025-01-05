package com.example.DigitalLibrary.database;




public class DatabaseConfig{

    private static DatabaseConfig instance;

    private DatabaseConfig(){
    }

    public static void testConnection(String databaseName, String portNumber) {

    }

    public static DatabaseConfig getInstance() {

        if(DatabaseConfig.instance == null){

            DatabaseConfig.instance = new DatabaseConfig();
        }
        return DatabaseConfig.instance;
    }
}
