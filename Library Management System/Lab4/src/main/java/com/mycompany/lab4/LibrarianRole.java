/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author Saad
 */
public class LibrarianRole {
    
    private BookDatabase booksDatabase = new BookDatabase("Books.txt");
    private StudentBookDatabase sBDatabase = new StudentBookDatabase ("StudentsBooks.txt");

    public LibrarianRole() {}

    public void addBook(String id, String title, String authorName, String publisherName, int quantity) {
        Book book = new Book(id, title, authorName, publisherName, quantity); 
        this.booksDatabase.insertRecord(book);
        if(this.booksDatabase.contains(id)) {
            Book book2 = (Book) (this.booksDatabase.getRecord(id));
            book.setQuantity((book2.getQuantity() + 1));
        }
        this.booksDatabase.saveTofile();
    }

    public ArrayList<Record> getListOfBooks() {
        return this.booksDatabase.returnAllRecords();
    }
    
    public ArrayList<Record> getListOfBorrowingOperations() {
        return this.sBDatabase.returnAllRecords();
    }

    public int borrowBook(String studentId, String bookId, LocalDate borrowDate) {
        if (this.booksDatabase.contains(bookId)) {
            System.out.println("This Book ID doesn't exist in the library");
            return -1;
        }
        
        Book book = (Book) (this.booksDatabase.getRecord(bookId));
        if(book.getQuantity() == 0 && this.sBDatabase.contains(studentId + "," + bookId)) {
            System.out.println("Sorry, This Book Is Out Of Stock !");
            return 0;
        }

        String key = studentId + "," + bookId;
        if(this.sBDatabase.contains(key)) {
            return 1;
        }
        
        book.setQuantity((book.getQuantity() - 1));
        this.booksDatabase.saveTofile();
        
        StudentBook stuDent = new StudentBook(studentId, bookId, borrowDate);
        this.sBDatabase.insertRecord(stuDent);
        this.sBDatabase.saveTofile();
        return 2;
    }

    public double returnBook(String studentId, String bookId, LocalDate returnDate) {
        if (!(this.booksDatabase.contains(bookId))) {
            System.out.println("This Book Doesn't Belong Here!");
            return -1;
        }
        
        Book book = (Book) (this.booksDatabase.getRecord(bookId));
        book.setQuantity((book.getQuantity() + 1));
        this.booksDatabase.saveTofile();
        
        String key = studentId + "," + bookId;
        StudentBook student = (StudentBook) (this.sBDatabase.getRecord(key));
        LocalDate borrowingDate = student.getBorrowDate();
        long numberOfDays = (ChronoUnit.DAYS.between(borrowingDate,returnDate));
        
        if(numberOfDays < 0){
            System.out.println("INVALID Return Date, You Cannot Return This Book Before Buying it !!!");
            return -1;
        }
        
        this.sBDatabase.deleteRecord(key);
        this.sBDatabase.saveTofile();
        
        if(numberOfDays <= 7 ) {
            return 0;
        }
        else {
            return (numberOfDays - 7) * 0.5d ;
        }
    }

    public void logout() {
        booksDatabase.saveTofile();
        sBDatabase.saveTofile();
    }    
}
