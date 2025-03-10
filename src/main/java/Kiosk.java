import java.util.Scanner;

public class Kiosk {
    Scanner input = new Scanner(System.in);
    Menu menu = new Menu();

    

    String MenuType = """
                [ MAIN MENU ]
                1. Burgers
                2. Drinks
                3. Desserts
                0. 종료      | 종료
                """;


    String hambugiList =  """
        [ SHAKESHACK MENU ]
        1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
        2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
        3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
        4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
        0. 뒤로가기                | 뒤로가기
        """;

    String drinkList = """
            [ DRINK MENU ]
        1. CokaCola             | W 2.0 |
        2. PepsiCola            | W 1.5 |
        3. PepsiColaZeroLime    | W 1.5 |
        4. Sprite               | W 1.5 |
       """;

    String sideList = """
             [ DRINK MENU ]
        1. Potato Fries         | W 2.0 |
        2. Onion Ring           | W 2.5 |
        """;



    
    public void start() {
        while(true){
            try{
                System.out.println(MenuType);
                String selectMenuType = input.nextLine();

                int orderTouched = Integer.parseInt(selectMenuType);
                switch (orderTouched){

                    case 0: {
                        System.out.println("프로그램 종료.");
                        System.exit(0);
                    }
                    case 1: {
                        hambugiOrder();
                        break;
                    }

                    case 2: {
                        drinkOrder();
                        break;
                    }
                    case 3: {
                        sideOrder();
                        break;
                    }
                }
            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println("잘못 입력하셨습니다. ");
            } catch (IndexOutOfBoundsException e2) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
        

    }
    public void hambugiOrder(){
        while(true) {
            try {
                System.out.println(hambugiList);
                String selectHambugi = input.nextLine();
                int hambugiTouched = Integer.parseInt(selectHambugi);


                if (hambugiTouched == 0) {
                    System.out.println("뒤로 가기");
                    break;
                } else {
                    // 메뉴가 1부터 시작하기 때문에, 그 것과 인덱스를 맞추기 위한 -1
                    System.out.println("선택한 메뉴: " + menu.getHambugi().get(hambugiTouched - 1).toString());
                    break;
                }
            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println("잘못 입력하셨습니다. ");
            } catch (IndexOutOfBoundsException e2) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }    
    }
    public void drinkOrder(){
        while(true) {
            try {
                System.out.println(drinkList);
                String selectDrink = input.nextLine();
                int drinkTouched = Integer.parseInt(selectDrink);


                if (drinkTouched == 0) {
                    System.out.println("뒤로 가기");
                    break;
                } else {
                    System.out.println("선택한 메뉴: " + menu.getDrinks().get(drinkTouched - 1).toString());
                    break;
                }
            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println("잘못 입력하셨습니다. ");
            } catch (IndexOutOfBoundsException e2) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
        
    }
    public void sideOrder(){
        while(true) {
            try {
                System.out.println(sideList);
                String selectSide = input.nextLine();
                int sideTouched = Integer.parseInt(selectSide);

                if (sideTouched == 0) {
                    System.out.println("뒤로 가기");
                    break;
                } else {
                    System.out.println("선택한 메뉴: " + menu.getSideMenu().get(sideTouched - 1).toString());
                    break;
                }
            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println("잘못 입력하셨습니다. ");
            } catch (IndexOutOfBoundsException e2) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}
