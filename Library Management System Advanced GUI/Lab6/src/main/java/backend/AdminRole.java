/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package backend;
import constant.FileNames;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Saad
 */

public class AdminRole {
    
    private LibrarianUserDatabase dataBase ;
    
    public AdminRole() {
    
        dataBase = new LibrarianUserDatabase(FileNames.LIBRARIANS_FILENAME);
    }

    public void setDataBase(LibrarianUserDatabase dataBase) {
        this.dataBase = dataBase;
    }
    
    public void addLibrarian(String librarianId, String name, String email, String address, String phoneNumber) {
        LibrarianUser user = new LibrarianUser(librarianId, name, email, address, phoneNumber);
        if (dataBase.contains(librarianId)) {
            JOptionPane.showMessageDialog(null, "The librarian With ID = " + librarianId + " already exists!");
            return;
        }
        this.dataBase.insertRecord(user);
        JOptionPane.showMessageDialog(null, "The librarian With ID = " + librarianId + " Was successfully added!");
    }
    
    public ArrayList<Record> getListOfLibrarians() {
        return this.dataBase.getAllRecords();
    }
    
    public void removeLibrarian(String key) {
        if (!(dataBase.contains(key))) {
            JOptionPane.showMessageDialog(null, "The librarian With ID = " + key + " Doesn't exist!");
            return;
        }
        this.dataBase.deleteRecord(key);
        JOptionPane.showMessageDialog(null, "The librarian With ID = " + key + " has been deleted!");
    }
    
    public void logout() {
        dataBase.saveTofile();
    }
}
    
    
