package com.example.DigitalLibrary.database.singletons;


import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig{

    private static DatabaseConfig instance;

    private final String urlTemplate = "jdbc:%s://%s:%s/%s";

    Dotenv dotenv = Dotenv.configure().load();

    private final String databaseName;
    private final String databasePort;
    private final String databaseTypeConnection;
    private final String databaseUrl;
    private final String databaseUser;
    private final String databasePassword;

    private DatabaseConfig(){

        databaseTypeConnection = dotenv.get("CONNECTION_TYPE");
        databaseUrl = dotenv.get("DATABASE_URL");
        databasePort = dotenv.get("DATABASE_PORT");
        databaseName = dotenv.get("DATABASE_NAME");
        databaseUser = dotenv.get("DATABASE_USER");
        databasePassword = dotenv.get("DATABASE_PASSWORD");
    }

    public Connection getConnection() {

        String connectionString = String.format(urlTemplate,databaseTypeConnection,databaseUrl,databasePort,databaseName);

        try {
            Connection connection = DriverManager.getConnection(connectionString, databaseUser, databasePassword);

            if(connection == null) System.out.println("Falha na conexão com o banco de dados");

            System.out.println("Conexão com banco de dados bem sucedida");
            return  connection;

        } catch (Exception e) {
            throw new RuntimeException("Error ao conectar a base de dados");
        }
    }

    public static DatabaseConfig getInstance() {

        if(DatabaseConfig.instance == null){

            DatabaseConfig.instance = new DatabaseConfig();
        }
        return DatabaseConfig.instance;
    }
}
