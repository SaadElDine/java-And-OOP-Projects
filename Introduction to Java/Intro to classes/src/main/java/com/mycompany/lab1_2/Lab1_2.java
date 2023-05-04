/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab1_2;

/**
 *
 * @author Saad
 */
public class Lab1_2 {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "Ahmed";
        student1.phoneNumber = "01234578945";
        student1.address = "Alexandria";
        student1.id = 61245;
        Student student2 = new Student();
        student2.name = "Aly";
        student2.phoneNumber = "01257577923";
        student2.address = "Cairo";
        student2.id = 56304;
        System.out.println("Student 1:");
        student1.displayStudent(student1.name, student1.phoneNumber, student1.address, student1.id);
        System.out.println("");
        System.out.println("Student 2:"); 
        student2.displayStudent(student2.name, student2.phoneNumber, student2.address, student2.id);
    }
}
