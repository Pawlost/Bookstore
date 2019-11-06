package cz.sspbrno.bookstore;

import com.google.common.collect.Multimap;
import cz.sspbrno.bookstore.books.Book;
import cz.sspbrno.bookstore.books.Content;
import cz.sspbrno.bookstore.interfaces.Day;
import cz.sspbrno.bookstore.interfaces.ReadableContent;
import cz.sspbrno.bookstore.interfaces.BookHandler;
import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.staff.ShopAssistent;

import java.util.ArrayList;
import java.util.HashMap;

public class Store implements BookHandler {
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
    public ArrayList<Content> getByGenre(Genre genre) {
        return null;
    }

    @Override
    public Content getByName(String name) {
        return null;
    }
}
