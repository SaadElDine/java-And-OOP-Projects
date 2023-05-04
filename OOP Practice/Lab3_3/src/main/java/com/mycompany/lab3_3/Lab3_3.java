/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab3_3;

/**
 *
 * @author Saad
 */
public class Lab3_3 {

    public static void main(String[] args) 
    {
        Company co = new Company("Alex Fert", 12050, 99999,25);
        Institution i = new Institution("Alex Fert", 12050, 99999);
        System.out.println(i.getName());
        System.out.println(i.getNumberOfEmployees());
        System.out.println(i.getClass());
        i.printData();
        System.out.println(i.toString());
        System.out.println(i.hashCode());
//        co.printData();
//        co.addEmployee();
//        co.printData();
//        co.setTaxValue(25);
//        System.out.println("Savings = " + co.getSavings());
//        System.out.println("Net Savings = " + co.getNetSavings());
//        co.printData();
//        co.setTaxValue(9);
//        co.printData();
        System.out.println("Net Savings = " + i.getNetSavings());
//        co.setTaxValue(5);
//        co.printData();
//        System.out.println("Net Savings = " + co.getNetSavings());
        
    }
}
