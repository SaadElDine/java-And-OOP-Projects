/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2_3;

/**
 *
 * @author Saad
 */
public class Student 
{
    private String name;
    private int age;
    private double gpa;
    
    public Student(String name, int age, double gpa)
    {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public void setGpa(double gpa)
    {
        this.gpa = gpa;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public double getGpa()
    {
        return gpa;
    }
    
    public char gradeFromGPA()
    {
        if(gpa >= 3.5 && gpa <= 4)
            return 'A';
        if(gpa >= 3)
            return 'B';
        if(gpa >= 2.5)
            return 'C';
        if(gpa >= 2)
            return 'D';
        if(gpa < 0)
            return 'X';
        return 'F';
    }
    
    public void report()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
        System.out.println("Then the grade of " + name + " = " + gradeFromGPA());
    }
}
