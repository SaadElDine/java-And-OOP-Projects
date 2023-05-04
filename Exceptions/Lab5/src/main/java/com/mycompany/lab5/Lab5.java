/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Saad
 */

public class Lab5 {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter First Number:");
        int x = s.nextInt();
        System.out.println("Enter Second Number:");
        int y = s.nextInt();
        
        saveTofile(x,y);
        int[] arr = readFromFile();
        if (arr[0] < 0 || arr[1] < 0) {
            throw new myException();
        }
        try {
            System.out.println(arr[0] / arr[1]);
        }
        catch(ArithmeticException e) {
            System.out.println("Divisor = 0");
        }

    }
    
    public static void saveTofile(int x, int y) {
        try {
            try (FileWriter myWriter = new FileWriter ("test.txt")) {
                    myWriter.write(x + "\n" + y);
            }
            System.out.println("Saved TO File");
        } 
        catch (IOException e) {
            System.out.println("ERROR OCCURED WHILE OPENING THE FILE!");
        }
    }  
    
    public static int[] readFromFile() {
        int[] arr = new int[2];
        try {
            File file = new File("test.txt");
            try (Scanner sc = new Scanner(file))
            {
                int i = 0;
                while (sc.hasNextLine())
                {
                    String number = sc.nextLine();
                    int s = Integer.parseInt(number);
                    arr[i] = s;
                    i++;
                }
            }   
        }
        catch(FileNotFoundException e) {
            System.out.print("ERROR OCCURED WHILE OPENING THE FILE!");
        }
        return arr;
    }
}
