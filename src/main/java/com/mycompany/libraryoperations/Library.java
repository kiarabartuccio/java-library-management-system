package com.mycompany.libraryoperations;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package com.mycompany.libraryoperations;
import com.mycompany.libraryoperations.Book;
import com.mycompany.libraryoperations.LibraryOperations;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 *
 * @author 2393920
 */
//library class: manages collection of Books objects and handles
public class Library implements LibraryOperations{
    private static Library instance; //static variable to hold single instance(one library object)
    
    private ArrayList<Book> books; //List holds all books in library, in memory
    
    //constrctor to initialze book list, private to avoid more than 1 instance:
    public Library() { //setting up empty list of books when library created
        books =  new ArrayList<>(); //checks if current book = printed book
    }
       
    public static Library getInstance(){ //makes sure only one instance of library is used
        //checks if current book = printed:
        if (instance == null){ 
            instance = new Library(); 
            instance.loadBooks();
        }
        return instance; //returns single instance of library to who asked
    } 

    public ArrayList<Book> getBooks() { //gives access to current list of books
        return books; //see if printed
    }
    
    //adding book to library since we are implementing LibraryOperations
    @Override
    public boolean addBook(Book book){ //methos ads book to library if not null
        //check if book object is not null
        if (book != null){
            //add book to list
            books.add(book);
            //print confirmation message
            System.out.println("Successfully added book!" + book.getTitle());
            return true; //indicates added successfully
        }else {
            //error message if book is null
            System.out.println("Unable to add book, book cannot be null");
            return false; //indicates failure to add
        }
        
    }
    
    @Override
    public String retrieveAllBooks() { //returns all books in string
        //empty string to store the list of books
        String allBooks = ""; //stores book details, adding book info of all books
        //loop through books
        for(int i = 0; i < books.size(); i++){
            //get present book
            Book presentBook = books.get(i);
            //concat book details to string so book's details go to string allBooks string(2 strings)
            allBooks = allBooks + presentBook.toString() + "\n";
        }
        return allBooks;
    }

    @Override
    public String retrieveBookByAuthor(String author) { //gets book by author
        //Loop through list of books
        for(int i = 0; i < books.size(); i++){
            //getting present book, from list
            Book presentBook = books.get(i);
            //check if present book's author is the same as the author given
            if(presentBook.getAuthor().equalsIgnoreCase(author)){
                //if theres a match return the matched book
                return("Book: " + presentBook);
            } 
        }
        //no match
        return null;
    }

    @Override
    public String retrieveBookByTitle(String title) { //return book based on title
        //Loop through list of books
        for(int i = 0; i < books.size(); i++){
            //getting present book, from list
            Book presentBook = books.get(i);
            //check if present book's title is the same as the title given
            if(presentBook.getTitle().equalsIgnoreCase(title)){
                //if theres a match return the matched book
                return("Book: " + presentBook);
            } 
        }
        //no match
        return null;
    }

    public Book retrieveBook(String str) { //gets book by author
        //Loop through list of books
        for(int i = 0; i < books.size(); i++){
            //getting present book, from list
            Book presentBook = books.get(i);
            //check if present book's author is the same as the author given
            if(presentBook.toString().equalsIgnoreCase(str)){
                //if theres a match return the matched book
                return presentBook;
            } 
        }
        //no match
        return null;
    }

    @Override
    public boolean removeBook(Book book) { //deletes book from list
        //check if book is not null before remove
        if(book != null){
            //check if book is in list
            if(books.contains(book)){
                //remove book
                books.remove(book);
                //true is successfully removed
                return true;
            }else{
                //false if book not found
                return false;
            }
        }else{
            return false; //if book is null
        }
    }
      
    //saves books to file books.ser, using serialization,
    //serializaton: convert objects to file format that we can store   
    public boolean saveBooks(){
        return saveBooks("books.ser");
    }
    
    public boolean saveBooks(String path){ //saves books to file
       try
           //create FileOuputStream object to write objects into file, link object with file path
           (FileOutputStream fos = new FileOutputStream(path)){
           //create ObjectOutputStream object
           ObjectOutputStream oos = new ObjectOutputStream(fos); //wraps file stream to entire objects
           //writing array list book to the file
           oos.writeObject(books);
           //close, finish writing
           fos.close();
           //if worked to save
           return true;
       }catch (IOException e){
           //error(saving,...)
           return false;
       }
    }
    
    //load list of books from books.ser file
    //desarialization: read file, rebuildobject
    public boolean loadBooks(){ //reads saved book list from file, loads onto memory
       try
           //create FileInputStream to read objects from file, link object with file path
           (FileInputStream fis = new FileInputStream("books.ser")){
           //create ObjetInputStream object
           ObjectInputStream ois = new ObjectInputStream(fis); //used to read objects like ArrayList<Book> from file
           //read object, cast to array list book
           books = (ArrayList<Book>) ois.readObject(); //replacing current book list with file one
           fis.close(); //close stream after reading
           return true; //if loading worked
       }catch (Exception e){
           return false; //error(file,...)
       }
       
    } 
   
    //write a file(textIO)
    //CSV = comma seperated values, Ex: (text format): Title,Author,ISBN,...
    //instanceof = keyword, check if an boject belongs to a specific class or subclass(checking if actual book or EBook)
    public boolean saveBooksToCSV() { //saves book in text format(CSV)
        try{
            //telling TextIO towrite file books.csv
            //anything printed using textIO, will go into books.csv
            TextIO.writeFile("books.csv");
            //wrting header row in csv file, linning up columns
            TextIO.putln("Type, title, Author, ISBN,");
            //loop through all books in book array list
            for(Book book : books){
                //check if book is a physical copy(printedBook)
                if(book instanceof PrintedBook){
                //cast to printedBook to get pages
                PrintedBook pb = (PrintedBook) book;
                //printed book info(formatting)
                //make books take care:
                //TextIO.putln("printed, " + pb.getTitle() + "," + pb.getAuthor() + "," + pb.getIsbn() + "," + pb.getPages());
                TextIO.putln(pb.toCSV());
            }
            //check if igital book (EBooks)
            else if(book instanceof EBook){
                    //cast to EBook to gte fileSize
                    EBook eb = (EBook) book;
                    //formatting for EBook
                    //make books take care:
                    //TextIO.putln("EBook, " + eb.getTitle() + "," + eb.getAuthor() + "," + eb.getIsbn() + "," + eb.getFileSize());
                    }  
        }
        //no errors
        return true;
    }catch (Exception e){
        //errors
        return false;
        
        }    
    }

}

