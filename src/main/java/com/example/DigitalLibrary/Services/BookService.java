package com.example.DigitalLibrary.Services;

import com.example.DigitalLibrary.Models.Book;
import com.example.DigitalLibrary.Utils.Templates;
import com.example.DigitalLibrary.Utils.Validations;
import com.example.DigitalLibrary.repositories.BookRepository;

import java.util.Scanner;

public class BookService {

    private BookRepository repository = new BookRepository();

    public void registerBook() {

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

        try {
            numberPages = Integer.parseInt(scan.next());
        } catch (Exception e) {

            throw new RuntimeException("O número de páginas deve ser um Número: " + e.getMessage());
        }

        if (!Validations.isAValidDate(released)) {
            throw new IllegalArgumentException("A data precisa estar no formato Dia/Mês/ano");
        }

        Book newBook = new Book(title, authorName, released, numberPages);

        try {
            newBook = this.repository.create(newBook);
            System.out.println( newBook.toString());
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

    }

    public void findOneBook(){

        String title;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o titulo do livro que deseja buscar: ");

        title = scanner.nextLine();

        try{
            Book foundBook = this.repository.showOne(title);

            System.out.println(foundBook.toString());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void registerHolders() {
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

        if (!Validations.isEmail(holderEmail)) {
            throw new IllegalArgumentException("Email Inválido");
        }
        if (!Validations.isPersonalIDValid(personalIDNumber)) {
            throw new IllegalArgumentException("CPF Inválido");
        }
    }
}



