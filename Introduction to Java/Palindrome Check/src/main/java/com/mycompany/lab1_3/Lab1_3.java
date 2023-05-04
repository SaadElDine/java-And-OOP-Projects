/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab1_3;
import java.util.*;
/**
 *
 * @author Saad
 */
public class Lab1_3 {
    public static boolean isPalindrome(String str)
    {
        str = str.replace(" ","");
        int n = str.length();
        for(int i=0 ; i < n/2 ; i++)
        {
            if (str.charAt(i) != str.charAt(n-i-1))
            {
                return false;
            }     
        }
        return true;
    }
    public static void main(String[] args) 
    {
        String str;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.print("Enter a String To Check If PALINDROME Or Not: (!MAX STRING LENGTH IS 100!)");
            str = sc.nextLine();
        }
        while(str.length() > 100);
        if(isPalindrome(str))
            System.out.print("[ " + str + " ] " + "Is PALINDROME !!");
        else 
            System.out.print("[ " + str + " ] " + "Is NOT PALINDROME !!");

    }
}
