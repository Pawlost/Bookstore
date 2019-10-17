package cz.sspbrno.main.interfaces;

import java.util.ArrayList;

public interface Economical {
    ArrayList<ReadableContent> buyByGenre(Genre genre);

    ReadableContent buyByName(String name);

    int sell(ReadableContent book);
}
