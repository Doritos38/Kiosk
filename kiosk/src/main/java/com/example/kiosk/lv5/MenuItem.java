package com.example.kiosk.lv5;

public class MenuItem {
    private final String name;
    private final double price;
    private final String info;

    public MenuItem(String name, double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getInfo() {
        return this.info;
    }
}
