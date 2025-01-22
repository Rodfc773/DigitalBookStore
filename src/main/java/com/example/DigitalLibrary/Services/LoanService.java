package com.example.DigitalLibrary.Services;

import com.example.DigitalLibrary.Models.Book;
import com.example.DigitalLibrary.Models.Holder;
import com.example.DigitalLibrary.Utils.Search;
import com.example.DigitalLibrary.Services.Register;

import java.util.Scanner;

public class LoanService {

    public static  void loanBook(Register register){

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome do usuário que quer alugar o livro: ");

        String holderName = scan.nextLine();

        System.out.println("Digite o nome do livro: ");

        String bookName = scan.nextLine();

        Holder foundholder = Search.linearSearchHolder(holderName, register.getHolders());
        Book foundBook = Search.linearSearchBook(bookName, register.getBooks());


        if(foundholder == null) throw new RuntimeException("User not found");
        if(foundBook == null) throw new RuntimeException("Book not found");

        if(foundBook.getHolderId() != -1) throw  new RuntimeException("The book is already loaned");

        foundholder.setBookInHandsID(foundBook.getId());

        foundBook.setHolderId(foundholder.getID());

        register.setHolder(foundholder);
        register.setBook(foundBook);

    }
}
