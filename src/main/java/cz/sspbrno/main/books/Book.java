package cz.sspbrno.main.books;

import cz.sspbrno.main.Market;
import cz.sspbrno.main.interfaces.Genre;
import cz.sspbrno.main.interfaces.ReadableContent;
import cz.sspbrno.main.staff.Author;

import java.util.Date;

public class Book extends Content implements ReadableContent {
    private boolean electronic;
    private int pages;
    private Author author;

    public Book(String name, Genre genre, int pages, Author author, boolean electronic){
        super(name, genre);
        this.pages = pages;
        this.author = author;
        this.electronic = electronic;
    }

    @Override
    public Date read(Date day) {
        return null;
    }

    @Override
    public int price() {
        return 0;
    }
}
