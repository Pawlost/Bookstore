package cz.sspbrno.main.staff;

import cz.sspbrno.main.interfaces.ReadableContent;
import cz.sspbrno.main.interfaces.Day;
import cz.sspbrno.main.interfaces.Economical;
import cz.sspbrno.main.interfaces.Genre;

import java.util.ArrayList;

public class ShopAssistent extends Person implements Economical {

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
    public ArrayList<ReadableContent> buyByGenre(Genre genre) {
        return null;
    }

    @Override
    public ReadableContent buyByName(String name) {
        return null;
    }

    @Override
    public int sell(ReadableContent book) {
        return 0;
    }
}
