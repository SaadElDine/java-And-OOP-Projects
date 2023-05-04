/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab2_1;
import java.util.*;

/**
 *
 * @author Saad
 */
public class Lab2_1 
{
    public static void displayArray(int[] arr,int n)
    {   
        if (n != 0)
        {
            System.out.print("[");
            for(int i=0; i<n-1 ;i++)
            System.out.print(arr[i]+", ");
            System.out.println(arr[n-1] + "]");
        }
    }
    public static boolean isPrime(int number)
    {
        if(number == 1)
            return false;
        for(int i=2 ; i <= number/2 ; i++)
        {
            if(number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) 
    {
        int  n, c = 0;
        Scanner sc = new Scanner(System.in);
        do
        {
            if(c==0)
                System.out.print("Enter N: ");
            if(c != 0)
                System.out.print("You should enter a positive integer number: ");
            n = sc.nextInt();
            c++;                
        }
        while(n <= 0);
        int counter = 0, k=0;
        int[] arr = new int[n];
        System.out.println("The prime numbers between 1 and " + n +" :");
        for(int i=2 ; i <= n ; i++)
            if(isPrime(i))
            {
                arr[k++] = i;
                counter++;
            }
        displayArray(arr,k);
        if(counter == 0)
            System.out.print("No Primes Numbers in this Range!");
        
    }
}
