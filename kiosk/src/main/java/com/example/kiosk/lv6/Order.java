package com.example.kiosk.lv6;

public class Order {
    private String itemName;
    private int itemCount;
    private double itemPrice;

    public Order(String itemName, int itemCount, double itemPrice){
        this.itemName = itemName;
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void addCount(){
        this.itemCount++;
    }
}
