package com.example.kiosk.lv2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            int count = 1;
            if (menuItems.isEmpty()) {
                System.out.println("메뉴가 존재하지 않습니다.");
            } else {
                for (MenuItem a : menuItems) {
                    System.out.println(count + ". " + a.name + " | W " + a.price + " | " + a.info);
                    count++;
                }
            }
            System.out.println("0. 종료   | 종료");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice <= menuItems.size() - 1 && choice > 0) {
                MenuItem choiceMenu = menuItems.get(choice - 1);
                System.out.println(choice+"번 메뉴 || 이름 : "+choiceMenu.name+" || 가격 : "+choiceMenu.price+" || 설명 : "+choiceMenu.info);
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
