package cz.sspbrno.main.books;

import cz.sspbrno.main.interfaces.Genre;

public abstract class Content {
    private String name;
    private Genre genre;

    public Content(String name, Genre genre){
        this.name = name;
        this.genre = genre;
    }
}
