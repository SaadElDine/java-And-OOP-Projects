/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import constant.FileNames;
import javax.swing.JOptionPane;

/**
 *
 * @author Saad
 */

public class LibrarianRole {
    
    private BookDatabase booksDatabase;
    private StudentBookDatabase sBDatabase;

    public LibrarianRole() {
        booksDatabase = new BookDatabase(FileNames.BOOKS_FILENAME);
        sBDatabase = new StudentBookDatabase (FileNames.STUDENTSBOOKS_FILENAME);
    }

    public void addBook(String id, String title, String authorName, String publisherName, int quantity) {
        Book book = new Book(id, title, authorName, publisherName, quantity); 
        if (booksDatabase.contains(id)) {
            JOptionPane.showMessageDialog(null, "The Book With ID = " + id + " already exists!");
            Book book2 = (Book) (this.booksDatabase.getRecord(id));
            book.setQuantity((book2.getQuantity() + 1));
            booksDatabase.saveTofile();
            return;
        }
        this.booksDatabase.insertRecord(book);
        JOptionPane.showMessageDialog(null, "The Book With ID = " + id + " Was successfully added!");
    }

    public ArrayList<Record> getListOfBooks() {
        return this.booksDatabase.getAllRecords();
    }
    
    public ArrayList<Record> getListOfBorrowingOperations() {
        return this.sBDatabase.getAllRecords();
    }

    public int borrowBook(String studentId, String bookId, LocalDate borrowDate) {
        if (!this.booksDatabase.contains(bookId)) {
            JOptionPane.showMessageDialog(null, "Sorry, The Book With ID = " + bookId + " Doesnt exist exist!");
            return -1;
        }
        
        Book book = (Book) (this.booksDatabase.getRecord(bookId));
        if(book.getQuantity() == 0 && !this.sBDatabase.contains(studentId + "," + bookId)) {
            JOptionPane.showMessageDialog(null, "Sorry,ALL copies of the book With ID = " + bookId 
                    + " have been borrowed and no copy is left for the student with ID = " + studentId +" !" );
            return 0;
        }

        String key = studentId + "," + bookId;
        if(this.sBDatabase.contains(key)) {
            JOptionPane.showMessageDialog(null, "The Student With ID = " + studentId + 
                    " has borrowed a copy of the book with ID = " + bookId + " and hasn't returned it yet!");
            return 1;
        }
        
        book.setQuantity((book.getQuantity() - 1));
        this.booksDatabase.saveTofile();
        
        StudentBook stuDent = new StudentBook(studentId, bookId, borrowDate);
        this.sBDatabase.insertRecord(stuDent);
        JOptionPane.showMessageDialog(null, "The student With ID = " + studentId 
                + " has successfully borrowed a copy of the book with ID = " + bookId + " !");
        return 2;
    }

    public double returnBook(String studentId, String bookId, LocalDate returnDate) {
        if (!(booksDatabase.contains(bookId))) {
            JOptionPane.showMessageDialog(null, "The Book With ID = " + bookId + " Doesn't exist!");
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
            System.out.println("INVALID Return Date, You Cannot Return This Book");
            return -1;
        }
        
        double fees ;
        this.sBDatabase.deleteRecord(key);
        
        if(numberOfDays <= 7 ) {
            fees = 0;
        }
        else {
            fees = (numberOfDays - 7) * 0.5d ;
        }
        JOptionPane.showMessageDialog(null, "The Student With ID = " + studentId + 
                    " should pay a return fee of " + fees + " US dolar for the book with ID = " + bookId + " !");
        return fees;
    }

    public void logout() {
        booksDatabase.saveTofile();
        sBDatabase.saveTofile();
    }    
}
