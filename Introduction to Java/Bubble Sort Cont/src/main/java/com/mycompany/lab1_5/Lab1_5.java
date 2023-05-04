/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab1_5;
import java.util.*;
/**
 *
 * @author Saad
 */
public class Lab1_5
{   public static void displayArray(int[] arr,int n)
    {   System.out.print("[");
        for(int i=0; i<n-1 ;i++)
            System.out.print(arr[i]+", ");
        System.out.println(arr[n-1] + "]");
    }
    public static int[] bubbleSort(int [] nums)
    {        
        int n = nums.length;  
        int temp = 0;  
         for(int i=0; i < n; i++)
         {  
            for(int j=1; j < (n-i); j++)
            {  
                if(nums[j-1] > nums[j])
                {    
                    temp = nums[j-1];  
                    nums[j-1] = nums[j];  
                    nums[j] = temp;  
                }  
            }  
         } 
         return nums;
    }
    public static void main(String[] args) 
    {
        int n;
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.print("Fill Your Array (comma separated):");
        str = sc.nextLine();
        String res[] = str.split(",");
        n = res.length;
        int[] arr = new int[n];
        for(int i=0 ; i<n ;i++)
        {
            arr[i] = Integer.parseInt(res[i]);
        }
        System.out.println("Original Array:");
        displayArray(arr,n);
        arr = bubbleSort(arr);
        System.out.println("Sorted Array:");
        displayArray(arr,n);
    }
}
