import Models.Book;
import Models.Holder;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {

        LocalDate publishedRawData = LocalDate.of(2012, 8, 12);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String published = publishedRawData.format(formatter);


        Book newBook = new Book("Eclipse", "Tolkien",published ,300);
        Holder newHolder = new Holder("Clark", "Steven", 18, "115-077514.94", "rfc@gmail.com",1);

        System.out.println(newBook.toString());
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(newHolder.toString());
    }
}