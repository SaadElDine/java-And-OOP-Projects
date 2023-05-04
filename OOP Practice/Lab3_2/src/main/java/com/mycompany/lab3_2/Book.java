/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_2;

/**
 *
 * @author Saad
 */
public class Book 
{
    private String name;
    private String author;
    private int id ;
    private double price;
   
    public Book(String name, String author, int id, double price) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getBookName() {
        return name;
    }
    
    public String getBookAuthor() {
        return author;
    }
    
    public int getBookId()
    {
        return id;
    }
    
    public double getBookPrice()
    {
        return price;
    }
}
