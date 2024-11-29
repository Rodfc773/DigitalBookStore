package Utils;

import Models.Book;
import Models.Holder;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {

    private int universalBookID = 1;
    private int universalHolderId = 1;

    private final ArrayList<Holder> holders = new ArrayList<>();
    private final ArrayList<Book> books = new ArrayList<>();


    public Register(){}

    public void registerBook(){

        String title;
        String authorName;
        String released;
        int numberPages;

        Scanner scan = new Scanner(System.in);

        Templates.registerBookMenu();

        System.out.println("Digite o Titulo do livro: ");

        title = scan.next();

        System.out.println("Digite o nome do autor: ");

        authorName = scan.next();

        System.out.println("Digite a data de publicação do livro (ex: 12/08/1999): ");

        released = scan.next();

        System.out.println("Digite o Nº de páginas: ");

        try{
            numberPages = Integer.parseInt(scan.next());
        }catch (Exception e){

            throw new RuntimeException("O número de páginas deve ser um Número: " + e.getMessage());
        }

        if(!Validations.isAValidDate(released)){

            throw new IllegalArgumentException("A data precisa estar no formato Dia/Mês/ano");
        }

        Book newBook = new Book(title, authorName, released, numberPages, universalBookID);

        this.books.add(newBook);
        this.universalBookID += 1;
    }

    public void getBooks(){

        Templates.startListBookTemplate();

        this.books.forEach(book -> {

            String information = book.toString();
            System.out.println(information);
        });

        Templates.endListBookTemplate();

    }
}
