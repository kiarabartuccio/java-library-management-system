package com.mycompany.libraryoperations;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package com.mycompany.libraryoperations;
import java.io.Serializable;
/**
 *
 * @author 2393920
 */
public abstract class Book implements Serializable/*has Book operations*//*has Book operations*/{
    //declare:
    protected String title;
    protected String author;
    protected String isbn;

    //Constructor initialzing book details
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
    
    //absract to convert book details to string
    public abstract String toString();
    
    public String toCSV(){
        return title + "," + author + "," + isbn;
    }
    
    
}

