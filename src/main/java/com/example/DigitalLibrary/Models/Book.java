package com.example.DigitalLibrary.Models;

import java.util.Date;

public class Book {

    private String title;
    private String author;
    private String published_date;
    private int pages;
    private int holderID;
    private int id;
    private String created_at;


    public Book(String bookName, String authorName, String published, int numberOfPages, int id){

        this.setBookName(bookName);
        this.setPublished(published);
        this.setId(id);
        this.setAuthorName(authorName);
        this.setNumberOfPages(numberOfPages);
        this.holderID = -1;
    }
    public Book(String bookName, String authorName, String published, int numberOfPages, int id, int holderId){

        this.setBookName(bookName);
        this.setPublished(published);
        this.setId(id);
        this.setAuthorName(authorName);
        this.setNumberOfPages(numberOfPages);
        this.setHolderId(holderId);
    }
    public Book(){};

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
        return title;
    }

    public String getAuthorName() {
        return author;
    }

    public String getPublished(){

        return this.published_date;
    }

    public int getHolderId(){
        return this.holderID;
    }
    public int getNumberOfPages() {
        return pages;
    }

    public String getCreatedAt(){ return this.created_at;}

    public void setNumberOfPages(int numberOfPages) {
        this.pages = numberOfPages;
    }

    public void setPublished(String published) {
        this.published_date = published;
    }

    public void setHolderId(int holderId){
        this.holderID = holderId;
    }

    public void setAuthorName(String authorName) {
        this.author = authorName;
    }

    public void setBookName(String bookName) {
        this.title = bookName;
    }

    public void setId(int id){this.id = id;}

    public void setCreatedAt(Date createdAt) {
        this.created_at = createdAt.toString();
    }
}
