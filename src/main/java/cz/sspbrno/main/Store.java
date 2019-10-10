package cz.sspbrno.main;

import cz.sspbrno.main.interfaces.BookInterface;
import cz.sspbrno.main.interfaces.Economy;
import cz.sspbrno.main.interfaces.Genre;
import cz.sspbrno.main.staff.Salesman;

import java.util.ArrayList;

public class Store implements Economy {
    private int soldBooks;
    private ArrayList<BookInterface> owned;
    private Salesman salesman;

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
