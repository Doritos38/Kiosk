package com.example.kiosk.lv6;

public class MenuItem {
    private final String name;
    private final double price;
    private final String info;

    public MenuItem(String name, double price, String info) {       //      상품 정보 생성
        this.name = name;
        this.price = price;
        this.info = info;
    }

    public String getName() {       //      상품이름 불러오기
        return this.name;
    }

    public double getPrice() {      //      상품 가격 불러오기
        return this.price;
    }

    public String getInfo() {       //      상품 정보 불러오기
        return this.info;
    }
}
