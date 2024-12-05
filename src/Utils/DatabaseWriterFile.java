package Utils;

import Models.Book;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;



public class DatabaseWriterFile {

    private static final Path BOOKS_FILE_PATH = Path.of("/home/rodrigo/IdeaProjects/DigitalLibrary/src/database/books.json");

    public static void saveBooksOnFile(List<Book> books) throws IOException {

        Files.createDirectories(BOOKS_FILE_PATH.getParent());
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");

        books.forEach((book -> {
            jsonBuilder.append(book.toJson());

            jsonBuilder.append(",\n");
        }));

        jsonBuilder.append("]");

        Files.write(BOOKS_FILE_PATH, jsonBuilder.toString().getBytes(StandardCharsets.UTF_8));
    }
}
