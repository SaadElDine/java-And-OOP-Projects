/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab2_2;
import java.util.*;
/**
 *
 * @author Saad
 */
public class Lab2_2 {

    public static void main(String[] args) {
        ComplexNumber firstNumber = new ComplexNumber(0,0);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, Enter first complex number: ");
        System.out.print("Real: ");
        firstNumber.setRealNumber(sc.nextDouble());
        System.out.print("Imaginary: ");
        firstNumber.setImgNumber(sc.nextDouble());
        System.out.print("The complex number entered: ");
        firstNumber.printComplexNumber();
        ComplexNumber secondNumber = new ComplexNumber(0,0);
        System.out.println("Please, Enter second complex number: ");
        System.out.print("Real: ");
        secondNumber.setRealNumber(sc.nextDouble());
        System.out.print("Imaginary: ");
        secondNumber.setImgNumber(sc.nextDouble());
        System.out.print("The complex number entered: ");
        secondNumber.printComplexNumber();
        ComplexNumber sum = firstNumber.addComplex(secondNumber);
        System.out.print("Result of adding = ");
        sum.printComplexNumber();
    }
}
