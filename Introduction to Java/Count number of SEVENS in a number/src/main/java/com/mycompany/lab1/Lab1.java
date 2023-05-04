/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab1;
import java.util.*;

/**
 *
 * @author Saad
 */
public class Lab1 {
    public static void countSevens(int number)
    {
        int remainder, counter = 0, copy = number;
        while(number > 0)
        {
            remainder = number % 10;
            if(remainder == 7)  // remainder % 7 == 0 is the same
                counter++;
            number/=10;     
        }
        System.out.print("--> Number of SEVENS in " + copy + " is " + counter + " .");
    }

    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.print("Enter A Number :");
            number = sc.nextInt();
        }
        while(number <= 0);
        countSevens(number);
    }
}
