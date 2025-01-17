package com.example.kiosk.lv6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Basket {
    private List<Order> shopingBasket = new ArrayList<>();

    public void addBasket(Order order) {
        boolean check = shopingBasket.stream().
                filter(o -> o.getItemName().equals(order.getItemName())).findFirst()
                .map(o -> {
                    o.addCount();
                    return true;
                })
                .orElse(false);

        if (!check) {
            shopingBasket.add(order);
        }
    }

    public void viewBasket() {
        IntStream.range(0, shopingBasket.size())
                .forEach(i -> System.out.printf("%d. %s | 수량 : %d개 | 가격 : %f%n", i + 1,
                        shopingBasket.get(i).getItemName(), shopingBasket.get(i).getItemCount(), shopingBasket.get(i).getItemPrice()));
    }

    public double totalPrice() {
        return shopingBasket.stream().map(o -> o.getItemCount() * o.getItemPrice())
                .reduce(0.0, (total, price) -> total + price);
    }

    public boolean checkEmpty() {
        return this.shopingBasket.isEmpty();
    }

    public void emptyBasket() {
        this.shopingBasket.clear();
    }

    public void delSelectItem(int num) {
        if (0 < num && num <= shopingBasket.size()) {
            this.shopingBasket.remove(num - 1);
        } else {
            System.out.println("잘못된");
        }
    }

}
