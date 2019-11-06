package cz.sspbrno.bookstore.books;

import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.interfaces.ReadableContent;
import cz.sspbrno.bookstore.staff.Author;

import java.util.Date;

public class Book extends Content implements ReadableContent {
    private boolean electronic;
    private int pages;
    private Author author;

    public Book(String name, Genre genre, int price, int pages, Author author, boolean electronic){
        super(name, genre, price);
        this.pages = pages;
        this.author = author;
        this.electronic = electronic;
    }

    @Override
    public Date read(Date day) {
        return null;
    }
}
