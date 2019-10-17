package cz.sspbrno.main.books;

import cz.sspbrno.main.Market;
import cz.sspbrno.main.interfaces.Genre;
import cz.sspbrno.main.interfaces.ReadableContent;
import cz.sspbrno.main.staff.Author;

import java.util.Date;

public class Magazine extends Book implements ReadableContent {
    private int vintage;
    private Date releaseDate;

    public Magazine(String name,Genre genre, int pages, Author author, boolean electronic) {
        super(name, genre, pages, author, electronic);
    }

    @Override
    public  Content releaseRandom(Market market) {
        return null;
    }

    @Override
    public Content releaseContent(String name, Genre genre) {
        return null;
    }
}
