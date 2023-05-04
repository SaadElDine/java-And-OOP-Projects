package Backend;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Saif
 */
public class Node {
     private Node parent ;
     private Node LeftChild ;
     private Node RightChild ;
     private int heightProperty;
     private String value;
     private ColorOfTheNode color ;

    Node(String value) { 
    this.heightProperty = 0;// why
    this.value = value;
    this.color =ColorOfTheNode.Red;// any node will be red in insertion 
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    } 

    public Node getLeftChild() {
        return LeftChild;
    }

    public void setLeftChild(Node LeftChild) {
        this.LeftChild = LeftChild;
    }

    public Node getRightChild() {
        return RightChild;
    }

    public void setRightChild(Node RightChild) {
        this.RightChild = RightChild;
    }

    public int getHeightProperty() {
        return heightProperty;
    }

    public void setHeightProperty(int heightProperty) {
        this.heightProperty = heightProperty;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ColorOfTheNode getColor() {
        return color;
    }

    public void setColor(ColorOfTheNode color) {
        this.color = color;
    }

     @Override
     public String toString(){
         return ""+this.value;
     }
}
