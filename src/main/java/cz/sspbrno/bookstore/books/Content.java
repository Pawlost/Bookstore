package cz.sspbrno.bookstore.books;

import cz.sspbrno.bookstore.interfaces.Genre;

public abstract class Content {
    private String name;
    private Genre genre;
    private int price;

    public Content(String name, Genre genre, int price) {
        this.name = name;
        this.genre = genre;
        this.price = price;
    }
}
