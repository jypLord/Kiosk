import java.util.Optional;

public class MenuItem {
    private final String name;
    private final double price;
    private final String description ;

    public MenuItem(String name, double price , String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
        this.description = null;
    }

    //햄버거 리스트
    public static final MenuItem ShackBurger = new MenuItem("ShackBurger", 6.9 , "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
    public static final MenuItem SmokeShack = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
    public static final MenuItem Cheeseburger = new MenuItem("Cheeseburger",6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
    public static final MenuItem Hamburger = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

    //음료 리스트
    public static final MenuItem CokaCola = new MenuItem("CokaCola", 2.0);
    public static final MenuItem pepsiCola = new MenuItem("pepsiCola", 1.5);
    public static final MenuItem pepsiColaZeroLime = new MenuItem("pepsiColaZeroLime", 1.5);
    public static final MenuItem sprite = new MenuItem("sprite", 1.5);

    //사이드 메뉴 리스트
    public static final MenuItem gamtui = new MenuItem("potato fries", 2.0);
    public static final MenuItem onionRing = new MenuItem("onion ring", 2.5);

    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public Optional<String> getDescription(){
        return Optional.ofNullable(this.description);
    }

    @Override
    public String toString(){
        return getName() +"|" + "W "+getPrice() + "|" + getDescription();
    }
}
