package cz.sspbrno.main.books;

import cz.sspbrno.main.interfaces.BookInterface;
import cz.sspbrno.main.interfaces.Genre;

public abstract class Content implements BookInterface {
    private String name;
    private String publisher;
    private Genre genre;

    public Content(){

    }
}
