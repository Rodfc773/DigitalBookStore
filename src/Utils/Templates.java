package Utils;

import java.util.HashMap;
import java.util.Map;

public class Templates {

    public static void mainMenu(){

        System.out.println("-------------- Bem vindo ao Digital Book Store, Sua Biblioteca Online --------------");
        System.out.println();
        System.out.println("                        Selecione uma das opções abaixo:                            ");
        System.out.println();
        System.out.println("---- 1: Cadastrar-se                                                                 ");
        System.out.println("---- 2: Cadastrar um novo livro no sistema                                           ");
        System.out.println("---- 3: Listar livros cadastrados                                                   ");
        System.out.println("---- 4: Desligar o sistema sistema                                                  ");
        System.out.println();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

    }
    public static void registerBookMenu(){

        System.out.println("-------------- Você está na opção de cadastro de livros -------------- ");
        System.out.println();
        System.out.println("                        Siga  as instruções abaixo:                    ");
        System.out.println();

    }
    public static void startListBookTemplate(){

        System.out.println("-------------- Livros Cadastrados -------------- ");

    }
    public static void endListBookTemplate(){
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
