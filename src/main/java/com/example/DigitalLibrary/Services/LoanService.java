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

    }
}
