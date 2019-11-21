package cz.sspbrno.bookstore.staff;

import cz.sspbrno.bookstore.books.Content;
import cz.sspbrno.bookstore.interfaces.Day;
import cz.sspbrno.bookstore.interfaces.Genre;

import java.util.ArrayList;

public class ShopAssistent extends Person implements BookHandler {

    private int id;
    private Day[] workDays;

    public ShopAssistent(int id, Day[] workDays){
        super();
        this.id = id;
        this.workDays = workDays;
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

	@Override
	public void interact() {
		
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public void updateText() {
		
	}
}
