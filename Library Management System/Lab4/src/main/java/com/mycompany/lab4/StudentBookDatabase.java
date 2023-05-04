/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;
import java.time.LocalDate;

/**
 *
 * @author Saad
 */

public class StudentBookDatabase extends DataBase{
    
    public StudentBookDatabase(String fileName) {
        super(fileName);
    }
    
    @Override
    public Record createRecordFrom(String line) {
        String splited[] = line.split(",");
        return new StudentBook(splited[0], splited[1], LocalDate.parse(splited[2]));
    }
}
