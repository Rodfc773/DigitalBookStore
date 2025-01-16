package com.example.DigitalLibrary.database;


import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig{

    private static DatabaseConfig instance;

    Dotenv dotenv = Dotenv.configure().load();

    private String databaseName;
    private String databasePort;
    private String databaseTypeConnection;
    private String databaseUrl;
    private String databaseUser;
    private String databasePassword;

    private DatabaseConfig(){

        databaseTypeConnection = dotenv.get("CONNECTION_TYPE");
        databaseUrl = dotenv.get("DATABASE_URL");
        databasePort = dotenv.get("DATABASE_PORT");
        databaseName = dotenv.get("DATABASE_NAME");
        databaseUser = dotenv.get("DATABASE_USER");
        databasePassword = dotenv.get("DATABASE_PASSWORD");
    }

    public void testConnection() {

        String urlTemplate = "jdbc:%s://%s:%s/%s";

        String connectionString = String.format(urlTemplate,databaseTypeConnection,databaseUrl,databasePort,databaseName);

        try {
            Connection connection = DriverManager.getConnection(connectionString, databaseUser, databasePassword);

            if(connection == null) System.out.println("Falha na conexão com o banco de dados");

            System.out.println("Conexão com banco de dados bem sucedida");

        } catch (Exception e) {
            System.out.println("Error ao realizar a conexão com banco de dados");
            e.printStackTrace();
        }
    }

    public static DatabaseConfig getInstance() {

        if(DatabaseConfig.instance == null){

            DatabaseConfig.instance = new DatabaseConfig();
        }
        return DatabaseConfig.instance;
    }
}
