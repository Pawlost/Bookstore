package cz.sspbrno.bookstore;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cz.sspbrno.bookstore.books.Book;
import cz.sspbrno.bookstore.books.Content;
import cz.sspbrno.bookstore.interfaces.BookHandler;
import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.staff.Author;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Market implements BookHandler {
    private Multimap<Genre, Content> booksByGenre;
    private HashMap<String, Content> booksByName;
    private ArrayList<Author> authors;
    public int marketMoney = 3000000;
    private Random random;

    public Market() {
        random = new Random();
        
        booksByName = new HashMap<>();
        authors = new ArrayList<>();
        booksByGenre = HashMultimap.create();

      //  Author author = new Author(firstName, lastName, age, money);
        //authors.add(author);

        for(String name : Data.BOOKS){
            Genre genre = Genre.values()[random.nextInt(Genre.values().length)];
            int price = random.nextInt(Data.MAX_MONEY_AMOUNT - Data.MIN_SELL_VALUE) + Data.MIN_SELL_VALUE;
            int pages = random.nextInt(Data.MAX_BOOK_PAGES - 1) + 1;
           // author = authors.get(random.nextInt(authors.size());

            boolean electronic = random.nextBoolean();

            Book book = null;//new Book(name, genre, price, pages, author, electronic);

            booksByGenre.put(genre, book);
            booksByName.put(name, book);
        }
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
