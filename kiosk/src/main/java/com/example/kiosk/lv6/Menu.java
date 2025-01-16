package com.example.kiosk.lv6;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private String category;
    private List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems) {        //      카테고리별 메뉴 생성
        this.category = category;
        this.menuItems = menuItems;
    }

    public List<MenuItem> getItems() {      //      카테고리별 메뉴 불러오기
        return new ArrayList<>(this.menuItems);
    }

    public String getCategory() {       //      카테고리 이름 불러오기
        return this.category;
    }

}
