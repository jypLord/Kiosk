package admin;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

// 메뉴 정보를 Json 파일로 관리하기 위한 두 번째 main 클래스.
public class KioskAdmin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int menuType = inputMenuType(scanner);

                switch (menuType) {
                    case 1: {
                        HamburgerCreator hamburger = new HamburgerCreator();

                        MenuItem menuItem= inputMenuItem(scanner);
                        hamburger.addMenuItem(menuItem);
                        hamburger.toJson();

                        break;
                    }
                    case 2: {
                        DrinkCreator drink = new DrinkCreator();

                        MenuItem menuItem= inputMenuItem(scanner);

                        drink.addMenuItem(menuItem);
                        drink.toJson();

                        break;
                    }
                    case 3: {
                        SideMenuCreator side =new SideMenuCreator();

                        MenuItem menuItem= inputMenuItem(scanner);

                        side.addMenuItem(menuItem);
                        side.toJson();

                        break;
                    }
                    case 0: {
                        System.exit(0);
                    }
                    default: {
                        throw new IllegalArgumentException();
                    }
                }
                System.out.println("json file load complete!");

            } catch (IllegalArgumentException outOfNumInputError) {
                System.out.println("Please input in (1, 2, 3, 0)");
            } catch (IOException pathError){
                System.out.println("Illegal json file path");
            }
        }
    }
    public static int inputMenuType(Scanner scanner) {
        System.out.println("""
                [ Administrator ]
                Please input a number about menu type.
                1. Hamburger
                2. Drinks
                3. Side Menu
                0. exit
                """);

        String MenuType = scanner.nextLine();
        return Integer.parseInt(MenuType);
    }

    public static MenuItem inputMenuItem(Scanner scanner){
        System.out.println(System.getProperty("user.dir") + "/src/main/java/json");
        System.out.println("""
                Write the Menu's information, divided by '&'
                         [ Example ]
                |  name   | price |           description            |
                Hamburger &  6.9  & 토마토, 양상추, 쉑소스가 토핑된 치즈버거
                   Cola   &  1.5
                """);

        String inputField = scanner.nextLine();
        String[] fields = inputField.split("&");

        String name = fields[0].trim();
        double price = Double.parseDouble(fields[1].trim());
        String description = (fields.length > 2) ? fields[2].trim() : null;

        MenuItem menuItem = new MenuItem(name, price, description);

        return menuItem;
    }
}
