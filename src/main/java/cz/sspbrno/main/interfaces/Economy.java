package cz.sspbrno.main.interfaces;

import java.util.ArrayList;

public interface Economy {
    ArrayList<BookInterface> buyByGenre(Genre genre);

    BookInterface buyByName(String name);

    int sell(BookInterface book);
}
