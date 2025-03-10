public class MenuItem {
    private final String name;
    private final double price;
    private final String description;

    public MenuItem(String name, double price , String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public static final MenuItem ShackBurger = new MenuItem("ShackBurger", 6.9 , "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
    public static final MenuItem SmokeShack = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
    public static final MenuItem Cheeseburger = new MenuItem("Cheeseburger",6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
    public static final MenuItem Hamburger = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");


    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString(){
        return getName() +"|" + "W "+getPrice() + "|" + getDescription();
    }
}
