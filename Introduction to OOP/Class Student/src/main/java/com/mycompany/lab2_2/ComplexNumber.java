/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2_2;

/**
 *
 * @author Saad
 */
public class ComplexNumber 
{
    private double real;
    private double imaginary;
    
    public ComplexNumber(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public void setRealNumber(double real)
    {
        this.real = real;
    }
    
    public void setImgNumber(double imaginary)
    {
        this.imaginary = imaginary;
    }
    
    public double getRealNumber()
    {
        return real;
    }
    
    public double getImgNumber()
    {
        return imaginary;
    }
    
    public void printComplexNumber()
    {
        System.out.println(real + (imaginary < 0 ? "": "+") + imaginary + "i" );
    }
    
    public ComplexNumber addComplex(ComplexNumber number)
    {
        ComplexNumber sum = new ComplexNumber(number.real + this.real , number.imaginary + this.imaginary);
        return sum;
    }
}
