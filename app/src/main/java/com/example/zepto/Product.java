package com.example.zepto;

public class Product {

    private String name;
    private int imageResId;
    private String price;
    private String mrp;
    private String quantity;
    private String description;
    public Product(String name,int imageResId,String price,String mrp,String quantity,String description){

        this.name=name;
        this.imageResId=imageResId;
        this.price=price;
        this.mrp=mrp;
        this.quantity=quantity;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getPrice() {
        return price;
    }

    public String getMrp() {
        return mrp;
    }

    public String getQuantity() {
        return quantity;
    }
    public String getDescription() { return description; }


}

