package cz.sspbrno.main.staff;

import cz.sspbrno.main.Data;
import cz.sspbrno.main.books.Content;

import java.util.ArrayList;

public class Customer extends Person {
    private int money;
    private Discount type;
    private ArrayList<Content> boughtBooks;

    public Customer() {
        money = random.nextInt(Data.MAX_MONEY_AMOUNT - Data.MIN_MONEY_AMOUNT) + Data.MIN_MONEY_AMOUNT;
        boughtBooks = new ArrayList<>(random.nextInt(Data.WANTED_BOOKS));
        if (age < 20) {
            type = Discount.Student;
        } else if (age > 60) {
            type = Discount.Normal;
        } else {
            type = Discount.Senior;
        }
        System.out.println(boughtBooks.size());
    }
}
