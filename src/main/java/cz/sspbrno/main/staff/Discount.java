package cz.sspbrno.main.staff;

public enum Discount {
    Senior (25),
    Student (33),
    Normal(0);

    public final int discount;

    Discount(int discount){
        this.discount = discount;
    }
}
