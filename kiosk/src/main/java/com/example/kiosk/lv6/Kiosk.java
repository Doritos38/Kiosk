package com.example.kiosk.lv6;


import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    private Basket basket = new Basket();

    public void start(List<Menu> menu) {
        while (true) {
            System.out.println("[ MAIN MENU ]");
            IntStream.range(0, menu.size())     //  메인메뉴 출력
                    .forEach(i -> System.out.printf("%d. %s%n", i + 1, menu.get(i).getCategory()));

            if (!basket.checkEmpty()) {        //  장바구니 있을경우 아래 메뉴 추가 표시
                System.out.println();
                System.out.println("[ ORDERS MENU ]");
                System.out.printf("%d. Orders       | 장바구니를 확인후 주문합니다.%n", menu.size() + 1);
                System.out.printf("%d. Cancle       | 진행중인 주문을 취소합니다.%n", menu.size() + 2);
            }
            System.out.println("0. 종료  | 종료");

            int choiceCtg = choice();

            if (choiceCtg > 0 && choiceCtg <= menu.size()) { //  상세메뉴
                detailedMenu(menu, choiceCtg);
            } else if (choiceCtg == menu.size() + 1 && !basket.checkEmpty()) {    //  주문메뉴
                orderMenu();
            } else if (choiceCtg == menu.size() + 2 && !basket.checkEmpty()) {    //  장바구니 비우기
                basket.emptyBasket();
                System.out.println("주문이 취소되었습니다");
            } else if (choiceCtg == 0) {   //  프로그램 종료
                System.out.println("프로그램이 종료됩니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private int choice() {   //  숫자 외의 다른것 입력 시 예외 처리
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("정확한 숫자를 입력하세요.");
                sc.nextLine();
            }
        }
    }

    private void detailedMenu(List<Menu> menu, int choiceCtg) {
        List<MenuItem> menuItems = menu.get(choiceCtg - 1).getItems();
        while (true) {
            System.out.printf("[ %s MENU ]%n", menu.get(choiceCtg - 1).getCategory());  //      선택 카테고리 상세 메뉴 출력
            IntStream.range(0, menuItems.size())
                    .forEach(i -> System.out.printf("%d. %s | W %f | %s%n", i + 1, menuItems.get(i).getName(), menuItems.get(i).getPrice(), menuItems.get(i).getInfo()));
            System.out.println("0. 뒤로가기");

            int choice = choice();

            if (choice == 0) {
                System.out.println("메인메뉴로 이동합니다.");     //      메인 카테고리 메뉴로 돌아가기
                break;
            } else if (choice <= menuItems.size() - 1 && choice > 0) {      //      선택한 상품 장바구니에 넣기
                MenuItem choiceMenu = menuItems.get(choice - 1);
                System.out.printf("선택한 메뉴: %s | W %f | %s%n", choiceMenu.getName(), choiceMenu.getPrice(), choiceMenu.getInfo());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인        2. 취소");
                int choiceBasket = choice();

                if (choiceBasket == 1) {
                    basket.addBasket(new Order(choiceMenu.getName(), 1, choiceMenu.getPrice()));
                    System.out.printf("%s가 장바구니에 추가되었습니다.%n", choiceMenu.getName());
                } else if (choiceBasket == 2) {
                    System.out.println("돌아갑니다.");
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void orderMenu() {
        while (true) {
            System.out.println("아래와 같이 주문하시겠습니까?");
            System.out.println();
            System.out.println("[ Orders ]");
            basket.viewBasket();
            System.out.println();
            System.out.println("[ Total ]");
            System.out.printf("W %f%n", basket.totalPrice());
            System.out.println("1. 주문       2. 장바구니에서 빼기        3. 돌아가기");

            int choiceOrder = choice();

            if (choiceOrder == 1) {
                payment(basket.totalPrice());   // 할인 처리 후 결제
                basket.emptyBasket();   //  장바구니 비우기
                break;
            } else if (choiceOrder == 2) {     //      선택해서 장바구니에서 빼기
                System.out.println("몇번 상품을 빼시겠습니까?");
                int delChoice = choice();
                basket.delSelectItem(delChoice);
                System.out.printf("%d번 상품을 장바구니에서 뺐습니다.", delChoice);
                break;
            } else if (choiceOrder == 3) {      //      메인 카테고리 메뉴로 돌아가기
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void payment(Double total) {
        System.out.println("할인 정보를 입력해주세요.");
        loop:
        while (true) {
            int position = choice();
            switch (position) {     //      할인 젹용 후 자동 결제
                case 1:
                    System.out.printf("주문이 완료되었습니다. 금액은 W %f 입니다.%n", User.MERITORIOUS.discount(total));
                    break loop;
                case 2:
                    System.out.printf("주문이 완료되었습니다. 금액은 W %f 입니다.%n", User.SOLDIER.discount(total));
                    break loop;
                case 3:
                    System.out.printf("주문이 완료되었습니다. 금액은 W %f 입니다.%n", User.STUDENT.discount(total));
                    break loop;
                case 4:
                    System.out.printf("주문이 완료되었습니다. 금액은 W %f 입니다.%n", User.PERSON.discount(total));
                    break loop;
                default:
                    System.out.println("잘못된 입력입니다.");       //      재선택
                    break;
            }
        }
    }

}
