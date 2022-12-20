package com.example.springboot.BookPackage;


import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idbook")
    private Long idbook;
    @Column(name = "title")
    String title;
    @Column(name = "author")
    String author;
    @Column(name = "page")
    int page;


    public Book() {
    }

    public Long getIdbook() {
        return idbook;
    }

    public void setIdbook(Long id) {
        this.idbook = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String bokTitle) {
        this.title = bokTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String bookAuthor) {
        this.author = bookAuthor;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int bookPage) {
        this.page = bookPage;
    }
}
