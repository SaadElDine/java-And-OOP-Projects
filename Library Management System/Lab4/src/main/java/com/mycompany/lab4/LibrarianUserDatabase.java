package com.mycompany.lab4;


/**
 *
 * @author Saad
 */

public class LibrarianUserDatabase extends DataBase {
    
    public LibrarianUserDatabase(String fileName) {
        super(fileName);
    }
    
    @Override
    public Record createRecordFrom(String line) {
        String splited[] = line.split(",");
        return new LibrarianUser(splited[0], splited[1], splited[2], splited[3], splited[4]);
    }
}
