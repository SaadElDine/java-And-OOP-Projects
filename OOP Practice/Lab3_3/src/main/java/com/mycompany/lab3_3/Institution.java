package com.mycompany.lab3_3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Saad
 */
public class Institution {
    private String name;
    private int numberOfEmployees;
    private double savings;
    
    public Institution(String name, int numberOfEmployees, double savings)
    {
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
        this.savings = savings;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setNumberOfEmployees(int numberOfEmployees)
    {
        this.numberOfEmployees = numberOfEmployees;
    }
            
    public void setSaving(double savings)
    {
        this.savings = savings;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getNumberOfEmployees()
    {
        return numberOfEmployees;
    }
    
    public double getSavings()
    {
        return savings;
    }
    
    public double getNetSavings()
    {
        return (savings - (savings * (7 / 100d)));
    }
    
    public void printData()
    {
        System.out.print("Data: " + name + ", " + numberOfEmployees + ", " + savings);
    }   
}


