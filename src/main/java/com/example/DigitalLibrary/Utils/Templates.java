package main.java.com.example.DigitalLibrary.Utils;

public class Templates {

    public static void mainMenu(){

        System.out.println("-------------- Bem vindo ao Digital Book Store, Sua Biblioteca Online --------------");
        System.out.println();
        System.out.println("                        Selecione uma das opções abaixo:                            ");
        System.out.println();
        System.out.println("---- 1: Cadastrar-se                                                                 ");
        System.out.println("---- 2: Cadastrar um novo livro no sistema                                           ");
        System.out.println("---- 3: Realizar emprestimo                                                   ");
        System.out.println("---- 4: Listar livros cadastrados                                                   ");
        System.out.println("---- 5: Listar Usuários                                                  ");
        System.out.println("---- 6: Desligar o sistema sistema                                                  ");
        System.out.println();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

    }
    public static void registerBookMenu(){

        System.out.println("-------------- Você está na opção de cadastro de livros -------------- ");
        System.out.println();
        System.out.println("                        Siga  as instruções abaixo:                    ");
        System.out.println();

    }
    public  static void registerholder(){

        System.out.println("-------------- Você está na opção de cadastro de Usuários -------------- ");
        System.out.println();
        System.out.println("                        Siga  as instruções abaixo:                    ");
        System.out.println();
    }
    public static void startListTemplate(String title){

        System.out.println("-------------- " + title + " -------------- ");

    }
    public static void endListBookTemplate(){
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
