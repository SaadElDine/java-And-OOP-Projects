/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

/**
 *
 * @author Saad
 */

public class BookDatabase extends DataBase {
    
    public BookDatabase(String fileName) {
        super(fileName);
    }
    
    @Override
    public Record createRecordFrom(String line) {
        String splited[] = line.split(",");
        return new Book(splited[0], splited[1], splited[2], splited[3], Integer.parseInt(splited[4]));
    }
}

