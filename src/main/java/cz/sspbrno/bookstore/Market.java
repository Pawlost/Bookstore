package cz.sspbrno.bookstore;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cz.sspbrno.bookstore.controllers.*;
import cz.sspbrno.bookstore.books.Book;
import cz.sspbrno.bookstore.books.Content;
import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.staff.Author;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Market {
    private Multimap<Genre, Content> booksByGenre;
    private HashMap<String, Content> booksByName;
    private ArrayList<Author> authors;
    public int marketMoney = 3000000;
    private Random random;
    private Store store;

    public Market(Store store) {
        random = new Random();
        this.store = store;

        booksByName = new HashMap<>();
        authors = new ArrayList<>();
        booksByGenre = HashMultimap.create();

        Author author = new Author("John R.R.", "Tolkien", 60, 1500);
        authors.add(author);
        author = new Author("Joanne K.", "Rowlingová", 54, 1500);
        authors.add(author);
        author = new Author("Erika¨L.", "James", 56, 1500);
        authors.add(author);
        author = new Author("Ernest", "Cline", 47, 1500);
        authors.add(author);
        author = new Author("Suzanne", "Collinsová", 57, 1500);
        authors.add(author);
        author = new Author("James", "Dashner", 46, 1500);
        authors.add(author);
        author = new Author("Alma", "Coinová", 54, 1500);
        authors.add(author);
        author = new Author("Karel", "Janeček", 46, 1500);
        authors.add(author);
        updateStore();

        for(String name : Data.BOOKS){
            Genre genre = Genre.values()[random.nextInt(Genre.values().length)];
            int price = random.nextInt(Data.MAX_MONEY_AMOUNT - Data.MIN_SELL_VALUE) + Data.MIN_SELL_VALUE;
            int pages = random.nextInt(Data.MAX_BOOK_PAGES - 1) + 1;
            author = authors.get(random.nextInt(authors.size()));

            boolean electronic = random.nextBoolean();

            Book book = new Book(name, genre, price, pages, author, electronic, store);

            author.addContent(book);

            booksByGenre.put(genre, book);
            booksByName.put(name, book);
        }
    }

    public void updateStore(){
        for(Author author : authors){
            author.setStore(store);
        }
    }

    public ArrayList<Content> getAllBooks(){
        return new ArrayList<>(booksByName.values());
    }

    public boolean isBookOnMarket(String name) {
        return booksByName.containsKey(name);
    }

    public int getMarketMoney() {
        return marketMoney;
    }

    public ArrayList<Author> getAuthors(){
        return authors;
    }
}
