package com.example.DigitalLibrary.Services;

import com.example.DigitalLibrary.Models.Book;
import com.example.DigitalLibrary.Models.Holder;
import com.example.DigitalLibrary.Utils.DatabaseReadFile;
import com.example.DigitalLibrary.Utils.Templates;
import com.example.DigitalLibrary.Utils.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {

    private int universalBookID = 1;
    private int universalHolderId = 1;

    private List<Holder> holders = new ArrayList<>();
    private List<Book> books = new ArrayList<>();


    public Register(){
        this.readBooksFromDatabase();
        this.readHoldersFromDatabase();
    }

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

        Book newBook = new Book(title, authorName, released, numberPages, this.universalBookID);

        this.books.add(newBook);
        this.universalBookID += 1;

    }

    public void registerHolders(){
        String holderEmail, firstName, lastName, personalIDNumber;
        int age;

        Scanner scan = new Scanner(System.in);

        Templates.registerholder();

        System.out.println("Digite o seu primeiro nome: ");

        firstName = scan.next();

        System.out.println("Digite o seu último nome: ");

        lastName = scan.next();

        System.out.println("Digite seu email: ");

        holderEmail = scan.next();

        System.out.println("Digite sua Idade: ");

        age = Integer.parseInt(scan.next());

        System.out.println("Digite seu CPF: ");

        personalIDNumber = scan.next();

        if(!Validations.isEmail(holderEmail)){ throw new IllegalArgumentException("Email Inválido");}
        if(!Validations.isPersonalIDValid(personalIDNumber)){throw new IllegalArgumentException("CPF Inválido");}

        Holder newHolder = new Holder(firstName,lastName,age,personalIDNumber, holderEmail, universalHolderId);

        this.universalHolderId += 1;

        this.holders.add(newHolder);
    }
    public List<Book> getBooks(){

        Templates.startListTemplate("Livros Cadastrados Disponiveis");

        this.books.forEach(book -> {

            if(book.getHolderId() == -1) {
                String information = book.toString();
                System.out.println(information);
                System.out.println("----------------------------");
            }
        });

        Templates.endListBookTemplate();

        return this.books;

    }

    public  void getStringHolders(){

        Templates.startListTemplate("Usuários cadastrados");

        this.holders.forEach(holder-> {
            String information = holder.toString();
            System.out.println(information);
            System.out.println("------------------------------------");
        });

        Templates.endListBookTemplate();
    }

    public  List<Holder> getHolders(){

        return this.holders;
    }
    public void readBooksFromDatabase(){
        try{
            this.books = DatabaseReadFile.readBooksAtJsonFile(this.books);
            this.universalBookID = this.books.size() + 1;
        } catch (Exception e) {
            System.out.println("Error at fetching Books data from JSON: " + e.getMessage());
        }
    }
    public void readHoldersFromDatabase(){
        try{
            this.holders = DatabaseReadFile.readHoldersFromFile(this.holders);
            this.universalHolderId = this.holders.size() + 1;
        } catch (Exception e) {
            System.out.println("Error at fetching holders data from JSON: " + e.getMessage());
        }
    }

    public void setHolder(Holder newData){
        this.holders.set(newData.getID(), newData);
    }

    public  void setBook(Book newData){
        this.books.set(newData.getId(), newData);
    }
}
