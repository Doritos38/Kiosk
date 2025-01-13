package com.example.kiosk.lv4;



import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        List<MenuItem> buggers = new ArrayList<>();
        List<MenuItem> drinks = new ArrayList<>();
        List<MenuItem> desserts = new ArrayList<>();
        List<Menu> menu = new ArrayList<>();

        buggers.add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        buggers.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        buggers.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        buggers.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));
        drinks.add(new MenuItem("water", 1.5, "시원한 물"));
        drinks.add(new MenuItem("juice", 3.0, "새콤달콤한 오렌지 주스"));
        drinks.add(new MenuItem("coffee", 2.5, "에티오피아 아라비카 원두를 사용한 커피"));
        drinks.add(new MenuItem("pepsi", 3.0, "콜라는 펩시"));
        desserts.add(new MenuItem("chocolate", 5.0, "달콤한 허쉬 초콜릿"));
        desserts.add(new MenuItem("donuts", 2.5, "계속 들어가는 도넛"));
        desserts.add(new MenuItem("potatoChips", 1.5, "짭짤한 감자칩"));
        desserts.add(new MenuItem("cookie", 5.0, "간단히 먹기 좋은 쿠키"));
        menu.add(new Menu("Buggers", buggers));
        menu.add(new Menu("Drinks", drinks));
        menu.add(new Menu("Desserts", desserts));

        kiosk.start(menu);
    }
}
