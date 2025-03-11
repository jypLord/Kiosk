import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //private inputScan;
    private MenuItem justForAddingToJangBaGuNI;

    private final List<MenuItem> JangBaGuNi = new ArrayList<>();
   // boolean JangBaguniIsContains = !JangBaGuNi.isEmpty();

    Scanner input = new Scanner(System.in);
    Menu menu = new Menu();


    public void start() {
        String MenuType = """
                [ MAIN MENU ]
                1. Burgers
                2. Drinks
                3. Desserts
                0. 종료      | 종료
                """;
        while(true){
            try{
                if(JangBaGuNi.isEmpty()){
                    System.out.println(MenuType);
                }else {
                    System.out.println(MenuType);
                    payOrExit();
                }

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
        String hambugiList =  """
        [ SHAKESHACK MENU ]
        1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
        2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
        3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
        4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
        0. 뒤로가기                | 뒤로가기
        """;
        while(true) {
            try {
                //위 텍스트박스 출력 & 사용자 입력
                System.out.println(hambugiList);
                String selectInput = input.nextLine();
                int inputScan = Integer.parseInt(selectInput);

                // 0 입력시 메인메뉴로 돌아가기
                if (inputScan == 0) {
                    System.out.println("뒤로 가기");
                    break;
                } else {
                    // 메뉴가 1부터 시작하기 때문에 입력을 1로 받음 -> 그 것과 리스트의 인덱스를 맞추기 위한 -1
                    justForAddingToJangBaGuNI = menu.getHambugi().get(inputScan - 1);
                    // 메뉴를 입력하고, 선택 메뉴가 맞는지 확인. 그리고 장바구니에 메뉴추가
                    System.out.println("선택한 메뉴: " + justForAddingToJangBaGuNI.toString());


                    addToJangBaGuNi(justForAddingToJangBaGuNI);
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
        String drinkList = """
            [ DRINK MENU ]
        1. CokaCola             | W 2.0 |
        2. PepsiCola            | W 1.5 |
        3. PepsiColaZeroLime    | W 1.5 |
        4. Sprite               | W 1.5 |
        0. 뒤로가기               | 뒤로가기
       """;
        while(true) {
            try {
                System.out.println(drinkList);
                String selectInput = input.nextLine();
                int inputScan = Integer.parseInt(selectInput);

                if (inputScan == 0) {
                    System.out.println("뒤로 가기");
                    break;
                } else {
                    // 메뉴 입력 -> 확인 -> 장바구니 메뉴추가
                    this.justForAddingToJangBaGuNI = menu.getDrinks().get(inputScan - 1);
                    System.out.println("선택한 메뉴: " + this.justForAddingToJangBaGuNI.toString());

                    addToJangBaGuNi(this.justForAddingToJangBaGuNI);

                    break;
                }
            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println("잘못 입력하셨습니다. ");
            } catch (IndexOutOfBoundsException e2) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
        
    }
    public void sideOrder() {
        String sideList = """
             [ DRINK MENU ]
        1. Potato Fries         | W 2.0 |
        2. Onion Ring           | W 2.5 |
        0. 뒤로가기               | 뒤로가기
        """;
        while (true) {
            try {
                System.out.println(sideList);
                String selectInput = input.nextLine();
                int inputScan = Integer.parseInt(selectInput);

                if (inputScan == 0) {
                    System.out.println("뒤로 가기");
                    break;
                } else {
                    this.justForAddingToJangBaGuNI = menu.getSideMenu().get(inputScan - 1);

                    System.out.println("선택한 메뉴: " + this.justForAddingToJangBaGuNI.toString());

                    addToJangBaGuNi(this.justForAddingToJangBaGuNI);
                    break;
                }
            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println("잘못 입력하셨습니다. ");
            } catch (IndexOutOfBoundsException e2) {
                System.out.println("잘못 입력하셨습니다.");
            } catch (IllegalArgumentException e3) {
                System.out.println("다시 입력하여 주십시오");
            }
        }
    }
    public void addToJangBaGuNi(MenuItem menuItem) {
        while (true) {
            String messageBox = """
                    "위 메뉴를 장바구니에 추가하시겠습니까?"
                    1. 확인               2. 취소
                    """;
            System.out.println(messageBox);
            String selectInput = input.nextLine();
            int inputScan = Integer.parseInt(selectInput);

            if (inputScan == 1) {
                this.JangBaGuNi.add(menuItem);
                System.out.println(menuItem.getName() + " 이 장바구니에 추가되었습니다.");
                break;
            } else if(inputScan == 2){
                System.out.println("취소되었습니다.");
                break;
            } else {
                throw new IllegalArgumentException("장바구니 입력 오류");
            }
        }
    }
    public void payOrExit(){
        String messageBox = """
                [ ORDER MENU ]
                4. Orders       | 장바구니를 확인 후 주문합니다.
                5. Cancel       | 진행중인 주문을 취소합니다.
                """;
        System.out.println(messageBox);
        String selectInput = input.nextLine();
        int inputScan = Integer.parseInt(selectInput);
        
        if(inputScan == 4) {
            System.out.println("[ Orders ]");

            // 선택한 모든 메뉴 출력
            for (MenuItem menus : JangBaGuNi) {
                System.out.println(menus);

            }
            System.out.println("[ Total ]");

            double price = 0;
            // 메뉴 총 가격 출력. 위의 price 에 총 가격 입력
            for (MenuItem menus : JangBaGuNi) {

                price += menus.getPrice();
                System.out.println("W " + price);
            }
            System.out.println("\n + 1. 주문      2. 메뉴판");

            // 1. 주문 2. 메뉴판의 입력받기. 1일때 결제
            String finalInput = input.nextLine();
            int realFinalInput = Integer.parseInt(finalInput);
            if(realFinalInput == 1){
                System.out.println("주문이 완료되었습니다. 금액은 W" + price +"입니다.");
            }else if(realFinalInput == 2){
                String MenuType = """
                [ MAIN MENU ]
                1. Burgers
                2. Drinks
                3. Desserts
                0. 종료      | 종료
                """;
                System.out.println(MenuType);

            }else{
                throw new IllegalArgumentException("결제화면 입력 오류");
            }

        // 5 입력시 장바구니 모두 비우기 -> 주문취소
        }else if(inputScan == 5){
            System.out.println("주문이 취소됩니다.");
            JangBaGuNi.clear();
            String MenuType = """
                [ MAIN MENU ]
                1. Burgers
                2. Drinks
                3. Desserts
                0. 종료      | 종료
                """;
            System.out.println(MenuType);

        }else{
            throw new IndexOutOfBoundsException("장바구니 확인화면 오류 ");
        }
    }
}
