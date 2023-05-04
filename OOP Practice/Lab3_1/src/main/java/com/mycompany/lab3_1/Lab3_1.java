/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab3_1;

/**
 *
 * @author Saad
 */
public class Lab3_1 {

    public static void main(String[] args) {
        Product p1 = new Product("H2");
        System.out.println(p1.getCost());
        System.out.println(p1.getName());
        System.out.println(p1.getPrice());
        System.out.println(p1.checkProfitability());
    }
}
