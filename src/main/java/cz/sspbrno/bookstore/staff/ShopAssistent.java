package cz.sspbrno.bookstore.staff;

import cz.sspbrno.bookstore.books.Content;
import cz.sspbrno.bookstore.controllers.Store;
import cz.sspbrno.bookstore.interfaces.Day;
import cz.sspbrno.bookstore.interfaces.Genre;

import java.util.ArrayList;

public class ShopAssistent extends Person{

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
	public void interact() {
		
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public void updateText() {
		
	}

	@Override
	public void setStore(Store store) {
		// TODO Auto-generated method stub
		
	}
}
