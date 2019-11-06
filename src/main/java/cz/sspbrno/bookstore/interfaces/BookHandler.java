package cz.sspbrno.bookstore.interfaces;

import cz.sspbrno.bookstore.books.Content;

import java.util.ArrayList;

public interface BookHandler {
    ArrayList<Content> getByGenre(Genre genre);

    Content getByName(String name);
}
