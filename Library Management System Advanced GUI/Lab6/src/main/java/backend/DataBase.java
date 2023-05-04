/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package backend;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

/**
 * @author Saad
 */

public abstract class DataBase {
    
    private ArrayList<Record> records = new ArrayList<>();
    private String fileName;
    public abstract Record createRecordFrom(String line);
       
    public DataBase(String fileName) {
        this.fileName = fileName;
        this.readFromFile();  // to avoid deleting the records saved if the user did not call read file function...
    }
    
    public String getFileName() {
        return fileName;
    }
        
    public void readFromFile()
    {
        try {
            File file = new File(this.fileName);
            try (Scanner sc = new Scanner(file))
            {
                String str;
                while (sc.hasNextLine())
                {
                    str = sc.nextLine();
                    Record r = createRecordFrom(str);
                    records.add(r);
                }
            }   
        }
        catch(FileNotFoundException e) {
            System.out.print("ERROR OCCURED WHILE OPENING THE FILE!");
        }
    }
    
    public ArrayList<Record> getAllRecords() {
        return records;
    }
    
    public boolean contains(String key) {
        for (int i = 0; i < this.records.size(); i++) {
            if (((this.records.get(i)).getSearchKey()).equals(key)) {
                return true;
            }
        }
        return false;
    }
    
    public Record getRecord(String key) {
        for (int i = 0; i < this.records.size(); i++) {
            if (((this.records.get(i)).getSearchKey()).equals(key)) {
                return this.records.get(i);
            }
        }
        return null;
    }
    
    public void insertRecord(Record record) {
        if(this.contains(record.getSearchKey())) {
            System.out.println("This ID Already Exists, Please Try Again Using Another ID!");
        }
        else{
            this.records.add(record);
            System.out.println(records.get(0).lineRepresentation());
            System.out.println("New Record Was Added Successfully!");
        }
    }
    
    public void deleteRecord(String key) {
        for (int i = 0; i < this.records.size(); i++) {
            if (((this.records.get(i)).getSearchKey()).equals(key)) {
                this.records.remove(i); 
            }
        }
    }
    
    public void saveTofile() {
        try {
            try (FileWriter myWriter = new FileWriter (this.fileName)) {
                for (int i = 0; i < this.records.size(); i++) {
                    myWriter.write((this.records.get(i)).lineRepresentation());
                }
            }
        } 
        catch (IOException e) {
            System.out.println("ERROR OCCURED WHILE OPENING THE FILE!");
        }
    }   
}
