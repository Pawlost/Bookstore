package cz.sspbrno.bookstore.staff;

import cz.sspbrno.bookstore.Data;
import cz.sspbrno.bookstore.books.Content;
import cz.sspbrno.bookstore.interfaces.BookHandler;
import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.controllers.*;

import java.util.ArrayList;

public class Customer extends Person implements BookHandler {
    private Discount type;
    private Content wantedBook;
    private Store store;

    public Customer(Content wantedBook, Store store) {
        super();
        this.store = store;
        this.wantedBook = wantedBook;
        money = random.nextInt(Data.MAX_MONEY_AMOUNT - Data.MIN_MONEY_AMOUNT) + Data.MIN_MONEY_AMOUNT;
        if (age < 20) {
            type = Discount.Student;
        } else if (age > 60) {
            type = Discount.Normal;
        } else {
            type = Discount.Senior;
        }

        this.setText(toString());
    }

    @Override
    public String toString() {
        if(wantedBook == null){
            return "Jméno: " + firstName +" "+lastName +", věk: "+age +" peníze: " + money;
        }else {
            return "Jméno: " + firstName +" "+lastName +", věk: "+age +" peníze: " + money+"\n tato osoba chce: " +
             wantedBook.toString() + " knihu";
        }
    }

    @Override
    public void interact() {
        store.buyBook(wantedBook, this);
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
