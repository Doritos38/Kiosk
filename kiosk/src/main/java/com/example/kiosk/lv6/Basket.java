package com.example.kiosk.lv6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Basket {
    private List<Order> shopingBasket = new ArrayList<>();

    public void addBasket(Order order){
        int count = 0;
        for(Order orders : shopingBasket){
            if(orders.getItemName().equals(order.getItemName())){
                orders.addCount();
                break;
            }
            count++;
        }
        if(count == shopingBasket.size()){
            shopingBasket.add(order);
        }
    }

    public void viewBasket(){
        IntStream.range(0, shopingBasket.size())
                .forEach(i -> System.out.println(i+1 + ". " + shopingBasket.get(i).getItemName() + " | 수량 : " +
                        shopingBasket.get(i).getItemCount() + "개 | 가격 : " + shopingBasket.get(i).getItemPrice()));
    }

    public double totalPrice(){
       return shopingBasket.stream().map(o -> o.getItemCount() * o.getItemPrice()).reduce(0.0, (total, price) -> total+price);
    }

    public boolean basketIsEmpty(){
        return this.shopingBasket.isEmpty();
    }

    public void emptyBacket(){
        this.shopingBasket.clear();
    }

}
