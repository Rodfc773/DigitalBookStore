package com.example.DigitalLibrary;

import com.example.DigitalLibrary.Services.BookService;
import com.example.DigitalLibrary.Utils.Templates;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        BookService bookService = new BookService();

        boolean online = true;

        while(online){

            Templates.mainMenu();

            int option = scan.nextInt();

            switch (option){

                case 1:

                    break;
                case 2:
                    try{
                        bookService.registerBook();
                    } catch (Exception e) {
                        System.out.println("Ocorreu o seguinte error ao cadastrar um livro: " + e.getMessage());
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    try{
                        bookService.findOneBook();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    online = false;

                    break;
            }

        }
        scan.close();
    }
}