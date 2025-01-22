package com.example.DigitalLibrary.Utils;

import com.example.DigitalLibrary.Models.Book;
import com.example.DigitalLibrary.Models.Holder;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class DatabaseWriterFile {

    private static final Path BOOKS_FILE_PATH = Path.of("/home/rodrigo/IdeaProjects/DigitalLibrary/src/main.java.com.example.DigitalLibrary.database/books.json");
    private static final Path HOLDERS_FILE_PATH = Path.of("/home/rodrigo/IdeaProjects/DigitalLibrary/src/main.java.com.example.DigitalLibrary.database/holders.json");

    public static void saveBooksOnFile(List<Book> books) throws IOException {

        Files.createDirectories(BOOKS_FILE_PATH.getParent());
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");

        books.forEach((book -> {
            jsonBuilder.append(book.toJson());

            jsonBuilder.append(",\n");
        }));

        jsonBuilder.deleteCharAt(jsonBuilder.length() - 2);
        jsonBuilder.append("]");

        Files.write(BOOKS_FILE_PATH, jsonBuilder.toString().getBytes(StandardCharsets.UTF_8));
    }

    public static void saveHoldersOnFile(List<Holder> holders) throws IOException{

        Files.createDirectories(HOLDERS_FILE_PATH.getParent());
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("[\n");

        holders.forEach((holder -> {
            jsonBuilder.append(holder.toJson());
            jsonBuilder.append(",\n");
        }));

        jsonBuilder.deleteCharAt(jsonBuilder.length()-2);
        jsonBuilder.append("]");

        Files.write(HOLDERS_FILE_PATH, jsonBuilder.toString().getBytes(StandardCharsets.UTF_8));
    }

}
