import Models.Book;
import Models.Holder;
import Utils.Templates;
import Utils.Validations;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private final ArrayList<Holder> holders = new ArrayList<>();
    private final ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean online = true;

        while(online){

            Templates.mainMenu();

            int option = scan.nextInt();

            switch (option){

                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("1");
                    break;
                default:
                    online = false;
                    break;
            }

        }
        scan.close();
    }
}