import Utils.Register;
import Utils.Templates;
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
                    break;
                case 2:
                    try{
                        register.registerBook();
                    } catch (Exception e) {
                        System.out.println("Ocorreu o seguinte error ao cadastrar um livro: " + e.getMessage());
                    }
                    break;
                case 3:
                    register.getBooks();
                    break;
                default:
                    online = false;
                    break;
            }

        }
        scan.close();
    }
}