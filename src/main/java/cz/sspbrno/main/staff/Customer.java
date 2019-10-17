package cz.sspbrno.main.staff;

import cz.sspbrno.main.Data;
import cz.sspbrno.main.books.Content;
import cz.sspbrno.main.interfaces.Economical;
import cz.sspbrno.main.interfaces.Genre;

import java.util.ArrayList;

public class Customer extends Person implements Economical {
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

    @Override
    public void makeMoney(int money) {

    }

    @Override
    public void spendMoney(int money) {

    }

    @Override
    public ArrayList<Content> buyByGenre(Genre genre) {
        return null;
    }

    @Override
    public Content butByName(String name) {
        return null;
    }

    @Override
    public Content buyByName(String name) {
        return null;
    }

    @Override
    public int sell(Content book) {
        return 0;
    }
}
