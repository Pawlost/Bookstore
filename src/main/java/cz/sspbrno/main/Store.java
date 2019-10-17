package cz.sspbrno.main;

import com.google.common.collect.Multimap;
import cz.sspbrno.main.books.Book;
import cz.sspbrno.main.interfaces.Day;
import cz.sspbrno.main.interfaces.ReadableContent;
import cz.sspbrno.main.interfaces.Economical;
import cz.sspbrno.main.interfaces.Genre;
import cz.sspbrno.main.staff.ShopAssistent;

import java.util.ArrayList;
import java.util.HashMap;

public class Store implements Economical {
    private int soldBooks;
    private Multimap<String, Book> books;
    private ArrayList<ReadableContent> owned;
    private HashMap<Integer, ShopAssistent> staff;
    private ShopAssistent currentAssistent;
    private Day[] openDays;

    public Store(){
        staff = new HashMap<>();
        Day[] workDays = new Day[]{Day.PONDELI, Day.UTERY, Day.STREDA};
        ShopAssistent assistent = new ShopAssistent(1, workDays);
        staff.put(1, assistent);

        workDays = new Day[]{Day.CTVRTEK, Day.PATEK};
        assistent = new ShopAssistent(2, workDays);
        staff.put(2, assistent);
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
