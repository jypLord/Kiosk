public class MenuItem {
    private String name;
    private short price;
    private String description;

    public MenuItem(String name, short price , String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void setMenuPrice(short price){
        this.price = price;
    }
}
