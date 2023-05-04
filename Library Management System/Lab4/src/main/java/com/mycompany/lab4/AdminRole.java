/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.lab4;
import java.util.ArrayList;

/**
 *
 * @author Saad
 */

public class AdminRole {
    
    private LibrarianUserDatabase dataBase = new LibrarianUserDatabase("Librarians.txt") ;
    
    public AdminRole() {}

    public void setDataBase(LibrarianUserDatabase dataBase) {
        this.dataBase = dataBase;
    }
    
    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber) {
        LibrarianUser user = new LibrarianUser(librarianId, name, email, address, phoneNumber);
        this.dataBase.insertRecord(user);
        this.dataBase.saveTofile();
    }
    
    public ArrayList<Record> getListOfLibrarians() {
        return this.dataBase.returnAllRecords();
    }
    
    public void removeLibrarian(String key) {
        this.dataBase.deleteRecord(key);
        this.dataBase.saveTofile();
    }
    
    public void logout() {
        dataBase.saveTofile();
    }
}
    
    
