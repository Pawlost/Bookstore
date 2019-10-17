package cz.sspbrno.main.books;

import cz.sspbrno.main.interfaces.Genre;
import cz.sspbrno.main.staff.Author;

public class BoardGame extends Book {
    private int players;
    private int ageRestriction;

    public BoardGame(String name, Genre genre, int pages, Author author, boolean electronic, int players, int ageRestriction) {
        super(name, genre, pages, author, electronic);
        this.players = players;
        this.ageRestriction = ageRestriction;
    }

    public void play(){

    }
}
