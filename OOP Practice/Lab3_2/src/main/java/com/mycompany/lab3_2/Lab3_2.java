/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab3_2;
import javax.swing.JOptionPane;

/**
 *
 * @author Saad
 */
public class Lab3_2 
{
    public static void main(String[] args) 
    {
        JOptionPane.showMessageDialog(null, "Welcome to my Program!");
        Book book1 = new Book("Algebra","Mahmoud",1,200);
        Book book2 = new Book("Geometry","Mohamed",2,250);
        Book book3 = new Book("Arabic","Ahmed",3,120);
        Book book4 = new Book("Programming","Saad",4,250.5);
        Book book5 = new Book("Maths","Mona",5,300);
        Book book6 = new Book("Physics","Adham",6,70);
        Book book7 = new Book("Morougue","Morougue",7,700);
        Reader reader1 = new Reader("Saad","01116668560");
        Reader reader2 = new Reader("Tarek","01116668560");
//        reader2.purshaseABook(book1);
//        reader2.purshaseABook(book7);
//        reader2.printPurshasedBooks();
//        reader2.printSumOfPurshasedBook();
//        reader2.setName("tarek salah");
//        reader2.printPurshasedBooks();
        reader1.purshaseABook(book7);
        reader1.purshaseABook(book7);
        reader1.purshaseABook(book7);
        reader1.printSumOfPurshasedBook();
//        reader2.printPurshasedBooks();
//        reader1.printPurshasedBooks();
//        reader1.purshaseABook(book7);
//        reader1.purshaseABook(book7);
//        reader1.purshaseABook(book7);
//        reader1.printPurshasedBooks();
//        reader1.printSumOfPurshasedBook();
//        reader1.purshaseABook(book2);
//        reader1.purshaseABook(book3);
        reader1.printPurshasedBooks();
        reader1.printSumOfPurshasedBook();
        reader1.purshaseABook(book7);
        reader1.purshaseABook(book5);
        reader1.printPurshasedBooks();
        reader1.purshaseABook(book7);
        reader1.printPurshasedBooks();
        reader1.printSumOfPurshasedBook();
        reader1.printAuthorBook("Mohamed");
        reader1.printAuthorBook("Mahmoud");
    }
}