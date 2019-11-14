package cz.sspbrno.bookstore.staff;

import cz.sspbrno.bookstore.Data;
import cz.sspbrno.bookstore.books.Content;
import cz.sspbrno.bookstore.interfaces.BookHandler;
import cz.sspbrno.bookstore.interfaces.Genre;

import java.util.ArrayList;

public class Customer extends Person implements BookHandler {
    private Discount type;
    private Content wantedBook;

    public Customer() {
        super();
        money = random.nextInt(Data.MAX_MONEY_AMOUNT - Data.MIN_MONEY_AMOUNT) + Data.MIN_MONEY_AMOUNT;
       // wantedBook = random.nextInt();
        if (age < 20) {
            type = Discount.Student;
        } else if (age > 60) {
            type = Discount.Normal;
        } else {
            type = Discount.Senior;
        }
    }

    @Override
    public String toString() {
        return "Jméno: " + firstName +" "+lastName +", věk: "+age +" peníze: " + money+"\n tato osoba chce: " +
        /*wantedBook.toString() + */" knihu";
    }

    @Override
    public void interact() {
        
    }


    @Override
    public void makeMoney(int money) {

    }

    @Override
    public void spendMoney(int money) {

    }

    @Override
    public ArrayList<Content> getByGenre(Genre genre) {
        return null;
    }

    @Override
    public Content getByName(String name) {
        return null;
    }

    @Override
    public boolean decide() {
        return false;
    }

}
