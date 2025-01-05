package main.java.com.example.DigitalLibrary.Models;

public class Book {

    private String bookName;
    private String authorName;
    private String published;
    private int numberOfPages;
    private int holderId;
    private int id;


    public Book(String bookName, String authorName, String published, int numberOfPages, int id){

        this.setBookName(bookName);
        this.setPublished(published);
        this.setId(id);
        this.setAuthorName(authorName);
        this.setNumberOfPages(numberOfPages);
        this.holderId = -1;
    }
    public Book(String bookName, String authorName, String published, int numberOfPages, int id, int holderId){

        this.setBookName(bookName);
        this.setPublished(published);
        this.setId(id);
        this.setAuthorName(authorName);
        this.setNumberOfPages(numberOfPages);
        this.setHolderId(holderId);
    }

    @Override
    public String toString() {

        String existHolder = this.getHolderId() == -1 ? "Livro Disponível": "Livro Indisponível";

        return String.format(
                "Id: %d\nTitulo: %s\nAutor: %s\nData de Publicamento: %s\nNúmero de Páginas: %d\nDisponibilidade: %s",
                this.getId(), this.getBookName(), this.getAuthorName(), this.getPublished(), this.getNumberOfPages(), existHolder);
    }
    public String toJson(){
        return String.format("{\"id\":%d,\"title\":\"%s\",\"author\":\"%s\",\"publishedDate\":\"%s\",\"numberOfPages\":%s,\"holder\":%d}",
                this.getId(),this.getBookName(), this.getAuthorName(), this.getPublished(), this.getNumberOfPages(), this.getHolderId());
    }

    public int getId(){
        return  this.id;
    }
    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublished(){

        return this.published;
    }

    public int getHolderId(){
        return this.holderId;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public void setHolderId(int holderId){
        this.holderId = holderId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setId(int id){this.id = id;}
}
