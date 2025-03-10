import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String menuList =  """
                [ SHAKESHACK MENU ]
                1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
                2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
                3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
                4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
                0. 종료                   | 종료
                """;
        System.out.println(menuList);

        while(true) {
            try {
                String order = input.nextLine();

                char orderCompleted = order.charAt(0);

                switch (orderCompleted) {
                    case 0: {
                        System.out.println("프로그램을 종료합니다.");
                        System.exit(0);
                    }
                    case 1:
                        System.out.println("가격: W 6.9");
                    case 2:
                        System.out.println("가격: W 8.9");
                    case 3:
                        System.out.println("가격: W 6.9 ");
                    case 4:
                        System.out.println("가격: W 5.4 ");
                }
            }catch(StringIndexOutOfBoundsException error) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}
