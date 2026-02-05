package com.example.zepto;

public class OrderModel {
    String productName, price, status;
    int imageResId, progress;

    public OrderModel(String productName, String price, int imageResId, String status, int progress) {
        this.productName = productName;
        this.price = price;
        this.imageResId = imageResId;
        this.status = status;
        this.progress = progress;
    }
}

