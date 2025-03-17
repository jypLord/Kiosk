package user;

import admin.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private MenuItem justForAddingToJangBaGuNI;

    private final List<MenuItem> JangBaGuNi = new ArrayList<>();


    Scanner input = new Scanner(System.in);
    Menu menu = new Menu();

    // 메뉴의 선택과 입력을 원활하게 하기 위한 공통 Scanner 객체
    String selectInput;
    int inputScan;

    public void start() {
        String MenuType = """
                [ MAIN MENU ]
                1. Burgers
                2. Drinks
                3. Desserts
                0. 종료      | 종료
                """;
        while(true){
            // 장바구니가 차 있으면 결제하기가 활성화 ↓↓
            boolean JangBaguniIsContains = !JangBaGuNi.isEmpty();

            try{
                System.out.println(MenuType);

                // 장바구니가 차 있으면 결제하기가 활성화
                if(JangBaguniIsContains){
                    String messageBox = """
                [ ORDER MENU ]
                4. Orders       | 장바구니를 확인 후 주문합니다.
                5. Cancel       | 진행중인 주문을 취소합니다.
                """;
                    System.out.println(messageBox);
                }

                selectInput = input.nextLine();

                inputScan = Integer.parseInt(selectInput);
                switch (inputScan){

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
                    case 4: {
                        if(JangBaguniIsContains) {
                            pay();
                        }else {
                            throw new IllegalArgumentException();
                        }
                    } case 5: {
                        if(JangBaguniIsContains) {
                            delete();
                        }else {
                            throw new IllegalArgumentException();
                        }
                    }

                }
            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println("잘못 입력하셨습니다. ");
            } catch (IndexOutOfBoundsException e2) {
                System.out.println("잘못 입력하셨습니다.");
            } catch (OrderCancelException e3) {
                // 메뉴판의 호출과, 주문 취소를 선택했을 때 while 루프를 초기화 하기 위한 예외
            } catch (IllegalArgumentException e4) {
                System.out.println("다시 입력하여 주십시오");
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
                selectInput = input.nextLine();
                inputScan = Integer.parseInt(selectInput);

                // 0 입력시 메인메뉴로 돌아가기
                if (inputScan == 0) {
                    System.out.println("뒤로 가기");
                } else {
                    // 메뉴가 1부터 시작하기 때문에 입력을 1로 받음 -> 그 것과 리스트의 인덱스를 맞추기 위한 -1
                    justForAddingToJangBaGuNI = menu.getHambugi().get(inputScan - 1);
                    // 메뉴를 입력하고, 선택 메뉴가 맞는지 확인. 그리고 장바구니에 메뉴추가
                    System.out.println("선택한 메뉴: " + justForAddingToJangBaGuNI.toString());


                    addToJangBaGuNi(justForAddingToJangBaGuNI);
                }
                break;
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
                selectInput = input.nextLine();
                inputScan = Integer.parseInt(selectInput);

                if (inputScan == 0) {
                    System.out.println("뒤로 가기");
                } else {
                    // 메뉴 입력 -> 확인 -> 장바구니 메뉴추가
                    this.justForAddingToJangBaGuNI = menu.getDrinks().get(inputScan - 1);
                    System.out.println("선택한 메뉴: " + this.justForAddingToJangBaGuNI.toString());

                    addToJangBaGuNi(this.justForAddingToJangBaGuNI);

                }
                break;
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
                selectInput = input.nextLine();
                inputScan = Integer.parseInt(selectInput);

                if (inputScan == 0) {
                    System.out.println("뒤로 가기");
                } else {
                    this.justForAddingToJangBaGuNI = menu.getSideMenu().get(inputScan - 1);

                    System.out.println("선택한 메뉴: " + this.justForAddingToJangBaGuNI.toString());

                    addToJangBaGuNi(this.justForAddingToJangBaGuNI);
                }
                break;
            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println("잘못 입력하셨습니다. ");
            } catch (IndexOutOfBoundsException e2) {
                System.out.println("잘못 입력하셨습니다.");
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
            selectInput = input.nextLine();
            inputScan = Integer.parseInt(selectInput);

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

    // Pay,exit 과 그 하위메서드에서만 쓰이는 필드 price
    private double price;

    public void pay() {
        System.out.println("[ Orders ]");

        // 선택한 모든 메뉴 출력
        JangBaGuNi.forEach(System.out::println);

        System.out.println("[ Total ]");

        // 메뉴 총 가격 출력. 위의 price 에 총 가격 입력
        price = JangBaGuNi.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
        System.out.println("W " + price);

        System.out.println("\n + 1. 주문      2. 메뉴 ");

        // 1, 2 입력받아 주문할지, 처음 화면(메뉴판)으로 돌아갈지 선택
        String finalInput = input.nextLine();
        int realFinalInput = Integer.parseInt(finalInput);
        if (realFinalInput == 1) {
            discount();
            System.out.println("주문이 완료되었습니다. 금액은 W" + price + "입니다.");
            System.exit(0);
        } else if (realFinalInput == 2) {
            throw new OrderCancelException();

        } else {
            throw new IllegalArgumentException("결제화면 입력 오류");
        }
    }

        // 5 입력시 장바구니 모두 비우기 -> 주문취소
    public void delete () {
        System.out.println("취소할 메뉴 이름을 적어주세요");
        System.out.println("[ Orders ]");
        // 선택한 모든 메뉴 출력
        JangBaGuNi.forEach(System.out::println);

        String inputToDelete = input.nextLine();

        //getter 사용하여 입력값과 객체의 Name 필드와의 비교. 맞으면 삭제하기.
        boolean findMenu = JangBaGuNi.stream()
                .anyMatch(menu -> menu.getName().equals(inputToDelete));
        if(findMenu) {
            JangBaGuNi.removeIf(menu -> menu.getName().equals(inputToDelete));

            System.out.println(inputToDelete + " 가 취소되었습니다.");
        }else{
            throw new IllegalArgumentException();
        }
    }
    public void discount () {
        String messageBlock = """
                할인 정보를 입력해주세요.
                1. 국가유공자 : 10%
                2. 군인     :  5%
                3. 학생     :  3%
                4. 일반     :  0%
                """;
        System.out.println(messageBlock);
        String discountInput = input.nextLine();
        int discountInput2 = Integer.parseInt(discountInput);

        // 숫자를 입력받아 Enum user.SocialTypeForDiscount 와 연계 → 할인율 리턴 → 할인된 가격을 필드 price 에 저장
        price += SocialTypeForDiscount.inputSocialType(discountInput2).getDiscountedPrice(price);
    }
}
