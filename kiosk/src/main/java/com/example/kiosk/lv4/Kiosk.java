package com.example.kiosk.lv4;


import java.util.List;
import java.util.Scanner;

public class Kiosk {

    public void start(List<Menu> menu) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[ MAIN MENU ]");
            int countCtg = 1;
            for (Menu menuSelect : menu) {
                System.out.println(countCtg + ". " + menuSelect.category);
                countCtg++;
            }
            System.out.println("0. 종료  | 종료");

            int choiceCtg = sc.nextInt();
            sc.nextLine();

            if (choiceCtg > 0 && choiceCtg <= menu.size()) {
                int countMenu = 1;
                while (true) {
                    List<MenuItem> menuItems = menu.get(choiceCtg - 1).getItems();
                    System.out.println("[ " + menu.get(choiceCtg - 1).category + " MENU ]");
                    for (MenuItem menuItem : menuItems) {
                        System.out.println(countMenu + ". " + menuItem.name + " | W " + menuItem.price + " | " + menuItem.info);
                        countMenu++;
                    }
                    System.out.println("0. 뒤로가기");

                    int choice = sc.nextInt();
                    sc.nextLine();

                    if (choice == 0) {
                        System.out.println("메인메뉴로 이동합니다.");
                        break;
                    } else if (choice <= menuItems.size() - 1 && choice > 0) {
                        MenuItem choiceMenu = menuItems.get(choice - 1);
                        System.out.println("선택한 메뉴: " + choiceMenu.name + " | W " + choiceMenu.price + " | " + choiceMenu.info);
                        countMenu = 1;
                    } else {
                        System.out.println("잘못된 입력입니다.");
                        countMenu = 1;
                    }
                }
            } else if (choiceCtg == 0) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

}
