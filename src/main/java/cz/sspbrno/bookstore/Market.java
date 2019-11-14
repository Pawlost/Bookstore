package cz.sspbrno.bookstore;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cz.sspbrno.bookstore.books.Content;
import cz.sspbrno.bookstore.interfaces.BookHandler;
import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.staff.Author;

import java.util.ArrayList;
import java.util.HashMap;

public class Market implements BookHandler {
    private Multimap<Genre, Content> booksByGenre;
    private HashMap<String, Content> booksByName;
    private ArrayList<Author> authors;
    public int marketMoney = 3000000;

    public Market() {
        booksByName = new HashMap<>();
        authors = new ArrayList<>();
        booksByGenre = HashMultimap.create();
    }

    private void addAuthor(String firstName, String lastName, int age, int money) {
        Author author = new Author(firstName, lastName, age, money);
        authors.add(author);
        author.releaseRandomBook(this);
    }

    public boolean isBookOnMarket(String name) {
        return booksByName.containsKey(name);
    }

    public int getMarketMoney() {
        return marketMoney;
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
