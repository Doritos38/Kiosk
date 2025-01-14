package com.example.kiosk.lv5;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private String category;
    private List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems){
        this.category = category;
        this.menuItems = menuItems;
    }

    public List<MenuItem> getItems(){
        return new ArrayList<>(this.menuItems);
    }

    public String getCategory(){
        return this.category;
    }
}
