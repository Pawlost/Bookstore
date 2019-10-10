package cz.sspbrno.main;

import com.google.common.collect.Multimap;
import cz.sspbrno.main.interfaces.BookInterface;
import cz.sspbrno.main.interfaces.Economy;
import cz.sspbrno.main.interfaces.Genre;

import java.util.ArrayList;
import java.util.HashMap;

public class Market implements Economy {
    private Multimap<Genre, BookInterface> genreBooks;
    private HashMap<String, BookInterface> nameBooks;

    public Market() {
        nameBooks = new HashMap<>();
        //genreBooks = new
    }

    @Override
    public ArrayList<BookInterface> buyByGenre(Genre genre) {
        return null;
    }

    @Override
    public BookInterface buyByName(String name) {
        return null;
    }

    @Override
    public int sell(BookInterface book) {
        return 0;
    }
}
