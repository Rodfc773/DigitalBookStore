package main.java.com.example.DigitalLibrary.Utils;

import main.java.com.example.DigitalLibrary.Models.Book;
import main.java.com.example.DigitalLibrary.Models.Holder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseReadFile {

    public static List<Book> readBooksAtJsonFile (List<Book> books) throws IOException
    {
        Path filePath = Path.of("/home/rodrigo/IdeaProjects/DigitalLibrary/src/main.java.com.example.DigitalLibrary.database/books.json");

        if(!Files.exists(filePath)){
            throw new IOException("Arquivo JSON contendo os dados dos livros não foi encontrado");
        }

        String jsonContent = Files.readString(filePath);
        jsonContent = jsonContent.trim().replaceAll("\\[|\\]","");
        String[] jsonItems = jsonContent.split("\\},\\s*\\{");

        for (String item: jsonItems){

            item = item.trim();

            if(!item.startsWith("{")) item = "{" + item;
            if(!item.endsWith("}")) item = item + "}";

            int id = Integer.parseInt(extractValue(item, "id"));
            String title = extractValue(item, "title");
            String author = extractValue(item, "author");
            String released = extractValue(item, "publishedDate");
            int pages = Integer.parseInt(extractValue(item, "numberOfPages"));
            int holderId = Integer.parseInt(extractValue(item, "holder"));

            Book book =  new Book(title, author, released, pages, id, holderId);

            books.add(book);

        }
        return books;
    }

    public static List<Holder> readHoldersFromFile(List<Holder> holders) throws IOException{

        Path filePath = Path.of("/home/rodrigo/IdeaProjects/DigitalLibrary/src/main.java.com.example.DigitalLibrary.database/holders.json");

        if(!Files.exists(filePath)) throw new IOException("Arquivo contendo os dados dos usuários não foram encontrados");

        String jsonContent = Files.readString(filePath);
        jsonContent = jsonContent.trim().replaceAll("\\[|\\]","");
        String[] jsonItems = jsonContent.split("\\},\\s*\\{");

        for (String item: jsonItems) {

            item = item.trim();

            if (!item.startsWith("{")) item = "{" + item;
            if (!item.endsWith("}")) item = item + "}";

            int id = Integer.parseInt(extractValue(item, "id"));
            String firstname = extractValue(item, "firstName");
            String lastName = extractValue(item, "lastName");
            int age = Integer.parseInt(extractValue(item, "age"));
            String idNumber = extractValue(item, "idNumber");
            String email = extractValue(item, "email");
            int bookOnHands = Integer.parseInt(extractValue(item, "booksInHand"));

            Holder holder = new Holder(firstname, lastName, age, idNumber, email, id);

            holder.setBookInHandsID(bookOnHands);

            holders.add(holder);
        }

        return holders;
    }


    private static String extractValue(String json, String key){
        String regex = "\"" + key + "\":\\s*\"?(.*?)\"?(,|})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(json);

        if(matcher.find()) return matcher.group(1).trim();

        return "";
    }
}
