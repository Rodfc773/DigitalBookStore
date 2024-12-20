package Utils;

import Models.Book;
import Models.Holder;

import java.util.List;

public class Search {

    public static Holder linearSearchHolder(String name, List<Holder> holders){

        for(Holder holder: holders){

            if(holder.getFullName().equalsIgnoreCase(name)) return holder;
        }

        return null;
    }

    public  static Book linearSearchBook(String name, List<Book> books){

        for(Book book: books){
            if (book.getBookName().equalsIgnoreCase(name)) return book;
        }

        return null;
    }
}
