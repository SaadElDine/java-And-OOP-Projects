/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_3;

/**
 *
 * @author Saad
 */
public class Company extends Institution  //inheritance
{
    private int taxPercent;
    
    public Company(String name, int numberOfEmployees, double savings, int taxPercent)
    {
        super(name, numberOfEmployees, savings);
       if(taxPercent >= 5 && taxPercent <=10)
        {
            this.taxPercent = taxPercent;
        }
        else 
            this.taxPercent = 7;
    }
    
    public void setTaxValue(int taxPercent)
    {
        if(taxPercent >= 5 && taxPercent <=10)
        {
            this.taxPercent = taxPercent;
        }
        else 
            this.taxPercent = 7;
        System.out.println("Tax Value Was set to " + this.taxPercent + " !");
    }
    
    public int getTaxValue()
    {
        return taxPercent;
    }
    
    @Override
    public double getNetSavings()
    {
        return (getSavings() - (getSavings() * (taxPercent / 100d)));  //Method Overriding
    }
    
    public void addEmployee()
    {
        setNumberOfEmployees((getNumberOfEmployees() + 1));
        System.out.println("One Employee was Successfully added!");
    }
    
    @Override
    public void printData()
    {
        super.printData();
        System.out.println(", " + taxPercent);
    }
}
