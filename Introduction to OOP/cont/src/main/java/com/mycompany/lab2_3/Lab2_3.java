/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab2_3;
import java.util.*;

/**
 *
 * @author Saad
 */
public class Lab2_3 {

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Student student1 = new Student(null,0,0);
        System.out.println("Enter Student 1 Data:");
        System.out.print("Name: ");
        student1.setName(sc.nextLine());
        System.out.print("Age: ");
        double gpa1;
        int i=0;
        student1.setAge(sc.nextInt());
        do
        {
            if(i==0)
            {
                System.out.print("Gpa: ");
            }
            if(i>0)
            {
                System.out.println("Invalid GPA , The GPA entered Can NOT Added !");
                System.out.print("Enter a Valid Gpa: ");
            }
            i++;
            gpa1 = sc.nextDouble();
        }
        while(gpa1 <= 0 || gpa1 > 4);
        student1.setGpa(gpa1);
        System.out.println("The data of the first student :");
        student1.report();
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println("");
        Scanner sc1 = new Scanner(System.in);
        Student student2 = new Student(null,0,0);
        System.out.println("Enter Student 2 Data:");
        System.out.print("Name: ");
        student2.setName(sc1.nextLine());
        System.out.print("Age: ");
        student2.setAge(sc1.nextInt());
        do
        {
            if(i==0)
            {
                System.out.print("Gpa: ");
            }
            if(i>0)
            {
                System.out.println("Invalid GPA , The GPA entered Can NOT Added !");
                System.out.print("Enter A Valid Gpa: ");
            }
            i++;
            gpa1 = sc.nextDouble();
        }
        while(gpa1 <= 0 || gpa1 > 4);
        student2.setGpa(gpa1);
        System.out.println("The data of the second student :");
        student2.report();
    }
}
