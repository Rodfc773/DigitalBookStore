import main.java.com.example.DigitalLibrary.Models.Book;
import main.java.com.example.DigitalLibrary.Models.Holder;
import main.java.com.example.DigitalLibrary.Services.LoanService;
import main.java.com.example.DigitalLibrary.Utils.DatabaseWriterFile;
import main.java.com.example.DigitalLibrary.Services.Register;
import main.java.com.example.DigitalLibrary.Utils.Templates;

import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Register register = new Register();

        boolean online = true;

        while(online){

            Templates.mainMenu();

            int option = scan.nextInt();

            switch (option){

                case 1:
                    try{
                        register.registerHolders();
                    }catch (Exception e){

                        System.out.println("Ocorreu o seguinte erro ao cadastrar um usuário: " + e.getMessage());
                    }
                    break;
                case 2:
                    try{
                        register.registerBook();
                    } catch (Exception e) {
                        System.out.println("Ocorreu o seguinte error ao cadastrar um livro: " + e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        LoanService.loanBook(register);
                    } catch (Exception e) {
                        System.out.println("Ocorreu o seguinte error ao fazer o emprestimo do livro: " + e.getMessage());
                    }
                    break;
                case 4:
                    register.getBooks();
                    break;
                case 5:
                    register.getStringHolders();
                    break;
                default:
                    List<Book> books = register.getBooks();
                    List<Holder> holders = register.getHolders();

                    try{
                        DatabaseWriterFile.saveBooksOnFile(books);
                        DatabaseWriterFile.saveHoldersOnFile(holders);
                    }catch (Exception e){
                        System.out.println("Não foi possivel salvar os dados nos arquivo json, ocorreu o seguinte erro: " + e.getMessage());
                    }
                    online = false;

                    break;
            }

        }
        scan.close();
    }
}