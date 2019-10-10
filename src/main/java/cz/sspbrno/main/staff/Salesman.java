package cz.sspbrno.main.staff;

import cz.sspbrno.main.interfaces.BookInterface;
import cz.sspbrno.main.interfaces.Economy;

public class Salesman extends Person implements Economy {

    private int id;

    public Salesman(){
    }

    @Override
    public BookInterface buy(int cena) {
        return null;
    }

    @Override
    public int sell(BookInterface book) {
        return 0;
    }
}
