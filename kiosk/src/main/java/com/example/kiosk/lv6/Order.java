package com.example.kiosk.lv6;

public class Order {
    private String itemName;
    private int itemCount;
    private double itemPrice;

    public Order(String itemName, int itemCount, double itemPrice) {        //      장바구니에 넣을 상품정보 생성
        this.itemName = itemName;
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {       //      상품이름 가져오기
        return itemName;
    }

    public int getItemCount() {     //      상품 개수 가져오기
        return itemCount;
    }

    public double getItemPrice() {      //      상품 가격 가져오기
        return itemPrice;
    }

    public void addCount() {        //      상품 개수 추가
        this.itemCount++;
    }
}
