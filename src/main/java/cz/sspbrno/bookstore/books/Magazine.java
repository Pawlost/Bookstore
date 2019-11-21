package cz.sspbrno.bookstore.books;

import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.interfaces.ReadableContent;
import cz.sspbrno.bookstore.staff.Author;

import java.util.Date;

public class Magazine extends Book{
    private int vintage;
    private Date releaseDate;

    public Magazine(String name, Genre genre, int price, int pages, Author author, boolean electronic) {
        super(name, genre, price, pages, author, electronic, null);
    }
}
