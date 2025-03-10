import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> hambugi = new ArrayList<>(Arrays.asList(MenuItem.ShackBurger, MenuItem.SmokeShack, MenuItem.Cheeseburger, MenuItem.Hamburger));

    Scanner input = new Scanner(System.in);

    public void start() {
        while (true) {
            try {
                String order = input.nextLine();

                int orderCompleted = Integer.parseInt(order);

                if (orderCompleted == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                } else {
                    // 메뉴가 1부터 시작하기 때문에, 그 것과 인덱스를 맞추기 위한 -1
                    System.out.println(hambugi.get(orderCompleted - 1).toString());
                    System.exit(0);
                }

            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println("잘못 입력하셨습니다. ");
            } catch (IndexOutOfBoundsException e2) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}
