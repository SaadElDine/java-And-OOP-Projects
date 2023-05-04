package model;

public class Product {
    private int id;
    private String name;
    private float price;
    private String picturePath;

    public Product(int id, String name, float price, String picturePath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picturePath = picturePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
    
    public String lineRepresentation() {
        return ( this.id + "," + this.name + "," + this.price + "," + this.picturePath);
    }
}
