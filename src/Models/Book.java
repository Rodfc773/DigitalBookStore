package Models;

public class Book {

    private String bookName;
    private String authorName;
    private String published;
    private int numberOfPages;
    private int holderId;


    public Book(String bookName, String authorName, String published, int numberOfPages){

        this.bookName = bookName;
        this.published = published;
        this.numberOfPages = numberOfPages;
        this.authorName = authorName;
        this.holderId = -1;
    }

    @Override
    public String toString() {
        return String.format(
                "Titulo: %s\nAutor: %s\nData de Publicamento: %s\nNúmero de Páginas: %d",
                this.getBookName(), this.getAuthorName(), this.getPublished(), this.getNumberOfPages());
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
}
