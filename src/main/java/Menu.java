import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    // 카테고리 별 메뉴 저장 리스트
    private final List<MenuItem> hambugi = new ArrayList<>(Arrays.asList(MenuItem.ShackBurger, MenuItem.SmokeShack, MenuItem.Cheeseburger, MenuItem.Hamburger));
    private final List<MenuItem> drink = new ArrayList<>(Arrays.asList(MenuItem.CokaCola, MenuItem.pepsiCola, MenuItem.pepsiColaZeroLime, MenuItem.sprite));
    private final List<MenuItem> sideMenu = new ArrayList<>(Arrays.asList(MenuItem.gamtui, MenuItem.onionRing));


    public List<MenuItem> getHambugi(){
        return this.hambugi;
    }
    public List<MenuItem> getDrinks(){
        return this.drink;
    }
    public List<MenuItem> getSideMenu(){
        return this.sideMenu;
    }
}
