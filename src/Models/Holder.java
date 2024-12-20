package Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Holder {

    private String firstName;
    private String lastName;
    private int age;
    private String idNumber;
    private String email;
    private int ID;
    private int bookInHandsID;

    public Holder(String firstName, String lastName, int age, String idNumber, String email,int ID) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setIdNumber(idNumber);
        this.setEmail(email);
        this.setID(ID);
        this.setBookInHandsID(-1);
    }

    @Override
    public String toString(){

        String information = String.format("Nome: %s\nIdade: %d\nEmail: %s",
                this.getFirstName() + " " + this.getLastName(), this.getAge(), this.getEmail());

        if (this.getBookInHandsID() != -1){
            information = information + "\nEstá em posso de um livro";
        }

        return information;
    }
    public String toJson(){

        return String.format(
                "{\"id\":\"%d\",\"firstName\":\"%s\",\"lastName\":\"%s\",\"age\":\"%d\",\"idNumber\":\"%s\",\"email\":\"%s\", \"booksInHand\":\"%d\"}",

                this.getID(), this.getFirstName(), this.getLastName(), this.getAge(), this.getIdNumber(), this.getEmail(), this.getBookInHandsID());
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public  String getFullName(){
        return  firstName + " " + lastName;
    }
    public int getAge() {
        return age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getID() {
        return ID;
    }

    public int getBookInHandsID() {
        return bookInHandsID;
    }

    public void setBookInHandsID(int bookInHandsID) {
        this.bookInHandsID = bookInHandsID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setAge(int age) {

        if(age <= 0 || age >= 150) throw new IllegalArgumentException("The field age is invalid");
        else if (age < 13) throw  new IllegalArgumentException("The Minimun age for loan a book is 13");

        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
