package user;

public enum SocialTypeForDiscount {
    Patriot(10),
    Soldier(5),
    Student(3),
    Ordinary(0);

    private final int discountPercent;

    SocialTypeForDiscount(int discountPercent){
        this.discountPercent = discountPercent;
    }
    public double getDiscountedPrice(double price){
        return price * (100.0 - discountPercent) /100.0;
    }

    public static SocialTypeForDiscount inputSocialType(int input){
        return switch (input){
            case 1 -> Patriot;

            case 2 -> Soldier;

            case 3 -> Student;

            default ->Ordinary;
        };
    }
}
