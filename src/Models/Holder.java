package Models;

public class Holder {

    private String firstName;
    private String lastName;
    private int age;
    private String idNumber;
    private String email;
    private int ID;

    public Holder(String firstName, String lastName, int age, String idNumber, String email, int ID) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.age = age;
        this.idNumber = idNumber;
        this.email = email;
        this.ID = ID;
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
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
