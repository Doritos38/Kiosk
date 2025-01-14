package com.example.kiosk.lv6;


import java.util.List;
import java.util.Scanner;

public class Kiosk {

    public void start(List<Menu> menu){
        Scanner sc = new Scanner(System.in);
        Basket basket = new Basket();
        while(true) {

            System.out.println("[ MAIN MENU ]");
            int countCtg = 1;
            for (Menu menuSelect : menu) {
                System.out.println(countCtg + ". " + menuSelect.getCategory());
                countCtg++;
            }
            if(!basket.basketIsEmpty()){
                System.out.println();
                System.out.println("[ ORDERS MENU ]");
                System.out.println(countCtg + ". Orders");
                countCtg++;
                System.out.println(countCtg + ". Cancle");
            }
            System.out.println("0. 종료  | 종료");

            int choiceCtg = sc.nextInt();
            sc.nextLine();

            if(choiceCtg > 0 && choiceCtg <= menu.size()) {
                int countMenu = 1;
                while (true) {
                    List<MenuItem> menuItems = menu.get(choiceCtg - 1).getItems();
                    System.out.println("[ " + menu.get(choiceCtg - 1).getCategory() + " MENU ]");
                    for (MenuItem menuItem : menuItems) {
                        System.out.println(countMenu + ". " + menuItem.getName() + " | W " + menuItem.getPrice() + " | " + menuItem.getInfo());
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
                        System.out.println("선택한 메뉴: " + choiceMenu.getName() + " | W " + choiceMenu.getPrice() + " | " + choiceMenu.getInfo());
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인        2. 취소");
                        int choiceBasket = sc.nextInt();
                        sc.nextLine();
                        if(choiceBasket == 1){
                            basket.addBasket(new Order(choiceMenu.getName(), 1, choiceMenu.getPrice()));
                            System.out.println(choiceMenu.getName() + " 이 장바구니에 추가되었습니다.");
                        }else if(choiceBasket == 2){
                            System.out.println("돌아갑니다.");
                        }else{
                            System.out.println("잘못된 입력입니다.");
                        }
                        countMenu = 1;
                    } else {
                        System.out.println("잘못된 입력입니다.");
                        countMenu = 1;
                    }
                }
            }else if(choiceCtg == 0){
                System.out.println("프로그램이 종료됩니다.");
                break;
            }else if(choiceCtg == menu.size()+1 && !basket.basketIsEmpty()){
                while(true){
                    System.out.println("아래와 같이 주문하시겠습니까?");
                    System.out.println();
                    System.out.println("[ Orders ]");
                    basket.viewBasket();
                    System.out.println();
                    System.out.println("[ Total ]");
                    System.out.println("W "+basket.totalPrice());
                    System.out.println("1. 주문       2. 메뉴판");

                    int choiceOrder = sc.nextInt();
                    sc.nextLine();

                    if(choiceOrder == 1){
                        System.out.println("주문이 완료되었습니다. 금액은 W " + basket.totalPrice() + " 입니다.");
                        basket.emptyBacket();
                        break;
                    }else if(choiceOrder == 2){
                        break;
                    }else{
                        System.out.println("잘못된 입력입니다.");
                    }
                }

            }else{
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

}
