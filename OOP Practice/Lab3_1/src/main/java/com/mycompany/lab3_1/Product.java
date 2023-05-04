/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab3_1;

/**
 *
 * @author Saad
 */
public class Product {
    private String name;
    private double price;
    private double cost;
    
    public Product(String name){
        this.name = name;
    }
    
    public Product(String name, double price, double cost){
        this.name = name;
        if(cost < 0){
            this.cost = 0;
        }
        
        else{
            this.cost = cost; 
        }
        
        if(price < 0){
            this.price = 1;
        }
        
        else{
            this.price = price;
        }
        
        if(price <= cost){
            this.price = this.cost + 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0){
            this.price = 1;
        }
        
        else{
            this.price = price;
        }
        
        if(price <= this.cost){
            this.price = this.cost + 1;
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if(cost < 0){
            this.cost = 0;
        }
        
        else{
            this.cost = cost; 
        }
        if(price <= this.cost){
            this.price = this.cost + 1;
        }
    }
    
    public boolean checkProfitability(){
            return (this.price - this.cost) >= 5;
        
    }   
}
