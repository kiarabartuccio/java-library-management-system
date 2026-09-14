package com.mycompany.libraryoperations;


import com.mycompany.libraryoperations.Book;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 2393920
 */
public class PrintedBook extends Book implements Serializable {
    //declare:
    private int pages;
    
    //constructor initializing printedBook details
    public PrintedBook(String title, String author, String isbn, int pages) {
        super(title, author, isbn); //taking it from book class
        this.pages = pages;
    }
    
    //getter to get number of pages
    public int getPages(){
        return getPages();
    }

    @Override
    public String toString() {
        return "Title: " + title + "  Author: " + author + "  ISBN: " + isbn + "  Pages: " + pages;
    }
    
    //need both since extending Book than implements Serializable(saves Serialized file):
    //save PrintedBook object to file
    public boolean saveBooks(String filename){
        try{
            //open filt input stream
            FileOutputStream fis = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            
          oos.writeObject(this); //writing PrintedBook object to file
          
          //close stream(s)
          oos.close(); 
          fis.close();
          
          return true; //returned true if can save
        }catch(IOException e){
            return false; //returned false if error
        }
    }
    
    public static PrintedBook loadBooks(String filename){
        PrintedBook book = null; //variable to hold loaded book
        try{
            //open file input stream
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            //read object from file, cast to PrintedBook
            book = (PrintedBook) ois.readObject();
            //close stream(s)
            ois.close();
            fis.close();
        }catch (Exception e){
        book = null; //error = book = null
        }
        return book; 
    }
    
        public String toCSV(){
            return "Printed," + super.toCSV() + "," + pages;
        }

    
}
