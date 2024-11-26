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

    public Holder(String firstName, String lastName, int age, String idNumber, String email, int ID) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setIdNumber(idNumber);
        this.setEmail(email);
        this.setID(ID);
        this.setBookInHandsID(-1);
    }


    public boolean idNumberValidation(){

        String cleanIdNumber = this.getIdNumber();
        return  false;
    }

    public boolean emailValidation(){

        String email = this.getEmail();
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);

        return  emailMatcher.matches();
    }
    @Override
    public String toString(){

        return String.format("Nome: %s\nIdade: %d\nEmail: %s",
                this.getFirstName() + " " + this.getLastName(), this.getAge(), this.getEmail());
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
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

        if(!this.emailValidation()) throw new IllegalArgumentException("Invalid email");

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
