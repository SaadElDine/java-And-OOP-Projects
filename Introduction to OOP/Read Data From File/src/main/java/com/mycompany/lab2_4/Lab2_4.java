/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab2_4;
import java.io.*;
import java.util.*;


/**
 *
 * @author Saad
 */
public class Lab2_4 
{
    private static int getLength(Student[] students)
    {
        int counter = 0;
        for(int i=0 ; i < students.length ; i++)
            if(students[i] == null)
                continue;
            else
                counter++;
        return counter;
    }
    
    public static Student [] readStudentDataFromFile(String filename) throws FileNotFoundException, IOException
    {
        try
        {
            File file = new File(filename);
            try (Scanner br = new Scanner(file))
            {
                int n = br.nextInt();
                br.nextLine();
                Student[] students = new Student[n];
                String str;
                int i = 0;
                while (br.hasNextLine())
                {
                    students[i] = new Student();
                    str = br.nextLine();
                    String splited[] = str.split(",");
                    students[i].setName(splited[0]);
                    students[i].setAge(Integer.parseInt(splited[1]));
                    students[i].setGpa(Double.parseDouble(splited[2]));
                    i++;
                }
                return students;
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.print("AN ERROR OCCURED !");
        }
        return null;
    }

    public static int getMaxGPAIndex(Student[] students)
    {
        int n = getLength(students);
        double max = 0;
        int maxIndex = 0;
        for(int i=0 ; i<n ; i++)
        {
            if(students[i].getGpa() > max)
            {
                max = students[i].getGpa();
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public static void main(String[] args) throws IOException , FileNotFoundException
    {
        //String filename; 
        //Scanner sc = new Scanner(System.in); 
        //System.out.print("Enter The File Name (ENDING WITH '.txt') :");
        //filename = sc.nextLine();
        Student[] students = readStudentDataFromFile("s.txt");
        int maxIndex = getMaxGPAIndex(students);
        students[maxIndex].report();
    }
}
