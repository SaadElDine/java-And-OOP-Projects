/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_2;

/**
 *
 * @author Saad
 */
public class Reader {
    
    private String name;
    private String phoneNumber;
    private Book[] purshasedBooks = new Book[5];  

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
   
    public Reader (String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    private int getLength (Book[] books) {
        
        int counter = 0;
        
        for (int i = 0; i < books.length; i++) {
            
            if(books[i] != null) {
                counter++;
            }   
        }
        
        return counter;
    }
    
    private boolean searchForBook (String bookName)
    {
        int numberOfBooks = getLength(purshasedBooks);
        
        for(int i = 0; i < numberOfBooks; i++)
        {
            
            if((purshasedBooks[i].getBookName()).equals(bookName))
                return true;
        }
        return false;
    }
    
    public void purshaseABook(Book book)
    {
        int index = getLength(purshasedBooks);
        
        if (index >= 5) {
            System.out.println("Sorry "  + name + ", You have reached the maximum limit!");
            return;
        }
        
        if(searchForBook(book.getBookName())) {
            System.out.println("Wow, you love " + book.getBookName() + " so much !!");
        }
        
        if (index < 5)
        {
            //index = (index-1) < 0 ? 0:index;
            purshasedBooks[index] = book;    //Composition
            System.out.println("You Have Purshased " + purshasedBooks[index].getBookName() + " Book" + " !");
            index++;
        }
    }
    
    public void printPurshasedBooks()
    {
        int numberOfBooks = getLength(purshasedBooks);
        if(numberOfBooks != 0)
        {
            System.out.println("Purshased Books: ");
            for(int i = 0; i< numberOfBooks; i++)
            {
                System.out.println("Book " + (i+1) + ": " + purshasedBooks[i].getBookName() + ", " + purshasedBooks[i].getBookAuthor() + ", " + purshasedBooks[i].getBookId() + ", " + purshasedBooks[i].getBookPrice());
            }
        }
        else
            System.out.println("Sorry " + name + ", No Purshased Books!");
    }
    
    public void printSumOfPurshasedBook()
    {
        double sum = 0;
        int numberOfBooks = getLength(purshasedBooks);
        if(numberOfBooks != 0)
        {
            for(int i = 0; i< numberOfBooks; i++)
            {
                sum += purshasedBooks[i].getBookPrice();
            }
        }
        else
        {
            System.out.println("Sorry " + name + ", No Purshased Books, Total Price = 0 EGP!");
            return;
        }
       System.out.println("Your Total Price of Purshasing " + numberOfBooks + " Book" + (numberOfBooks == 1 ? " ":"s " ) + " = " + sum + " EGP.");
    }      
    
    public void printAuthorBook(String authorName)
    {
        int numberOfBooks = getLength(purshasedBooks);
        boolean check = false;
        if(numberOfBooks != 0)
        {
            for(int i = 0; i < numberOfBooks; i++)
            {
                if(purshasedBooks[i].getBookAuthor().equals(authorName))
                {
                    System.out.println("Book Data: " + purshasedBooks[i].getBookName() + ", " + purshasedBooks[i].getBookAuthor() + ", " + purshasedBooks[i].getBookId() + ", " + purshasedBooks[i].getBookPrice());
                    check = true;
                }  
            }
        }
        else
            System.out.println("No books for this author !");
        if(!check)
            System.out.println("No books for this author !");
    }   
}
