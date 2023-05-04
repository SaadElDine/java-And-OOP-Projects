/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1_2;

/**
 *
 * @author Saad
 */
public class Student {
    String name;
    String phoneNumber;
    String address;
    int id;
    public void displayStudent(String name, String phoneNumber, String address, int id)
    {
        System.out.println("Name: " + name + ".");
        System.out.println("ID: " + id + ".");
        System.out.println("Phone Number: " + phoneNumber + ".");
        System.out.println("Address: " + address + ".");
    }
}
