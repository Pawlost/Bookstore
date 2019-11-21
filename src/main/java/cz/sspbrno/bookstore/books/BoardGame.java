package cz.sspbrno.bookstore.books;

import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.staff.Author;

public class BoardGame extends Book {
    private int players;
    private int ageRestriction;

    public BoardGame(String name, Genre genre, int price, int pages, Author author, boolean electronic, int players, int ageRestriction) {
        super(name, genre, pages, price, author, electronic, null);
        this.players = players;
        this.ageRestriction = ageRestriction;
    }

    public void play() {

    }
}
