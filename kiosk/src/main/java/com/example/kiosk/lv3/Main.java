package com.example.kiosk.lv3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        List<MenuItem> menuList = new ArrayList<>(menu.menu);
        loop:
        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            int count = 1;
            if (menuList.isEmpty()) {
                System.out.println("메뉴가 존재하지 않습니다.");
            } else {
                for (MenuItem a : menuList) {
                    System.out.println(count + ". " + a.name + " | W " + a.price + " | " + a.info);
                    count++;
                }
            }
            System.out.println("0. 종료   | 종료");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break loop;
            } else if (choice > menuList.size() - 1 || choice < 0) {
                System.out.println("존재하지 않은 메뉴입니다.");
            } else {
                MenuItem choiceMenu = menuList.get(choice - 1);
                System.out.println(choiceMenu.name + "을 선택하셨습니다.");
            }
        }
    }
}
