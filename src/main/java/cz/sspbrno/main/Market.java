package cz.sspbrno.main;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cz.sspbrno.main.books.Content;
import cz.sspbrno.main.interfaces.Genre;
import cz.sspbrno.main.staff.Author;

import java.util.ArrayList;
import java.util.HashMap;

public class Market {
    private Multimap<Genre, Content> booksByGenre;
    private HashMap<String, Content> booksByName;
    private ArrayList<Author> authors;
    public static final int GLOBAL_MONEY = 300000;
    public int marketMoney = GLOBAL_MONEY;

    Market() {
        booksByName = new HashMap<>();
        authors = new ArrayList<>();
        booksByGenre = HashMultimap.create();

        addAuthor("Pawel", "Baldakus", 10);
        addAuthor("Jane", "Bubla", 99);
    }

    private void addAuthor(String firstName, String lastName, int age) {
        Author author = new Author(firstName, lastName, age);
        authors.add(author);
        author.releaseRandomBook(this);
    }

    public boolean isBookOnMarket(String name) {
        return booksByName.containsKey(name);
    }
}
