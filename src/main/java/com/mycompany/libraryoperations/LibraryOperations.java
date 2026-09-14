/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.libraryoperations;

//import java.awt.print.Book;

/**
 *
 * @author 2393920
 */
public interface LibraryOperations {
    //defining operations needed:
     boolean addBook(Book book);
     String retrieveAllBooks();
     String retrieveBookByAuthor(String author);
     String retrieveBookByTitle(String title);
     boolean removeBook(Book book);
    
}

