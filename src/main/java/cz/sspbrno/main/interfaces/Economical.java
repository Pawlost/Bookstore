package cz.sspbrno.main.interfaces;

import cz.sspbrno.main.books.Content;

import java.util.ArrayList;

public interface Economical {
    ArrayList<Content> buyByGenre(Genre genre);

    Content butByName(String name);
}
