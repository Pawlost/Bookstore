package cz.sspbrno.main;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cz.sspbrno.main.interfaces.ReadableContent;
import cz.sspbrno.main.interfaces.Economical;
import cz.sspbrno.main.interfaces.Genre;
import cz.sspbrno.main.staff.Author;

import java.util.ArrayList;
import java.util.HashMap;

public class Market implements Economical {
    private Multimap<Genre, ReadableContent> booksByGenre;
    private HashMap<String, ReadableContent> booksByName;
    private ArrayList<Author> authors;

    public Market() {
        booksByName = new HashMap<>();
        authors = new ArrayList<>();
        booksByGenre = HashMultimap.create();

        for(int a = 0; a < Data.MAX_AUTHORS; a++){
            addAuthor();
        }
    }

    public void addAuthor(){
        Author author = new Author();
        authors.add(author);
        author.releaseRandomBook();
    }

    public boolean isBookOnMarket(String name){
        return booksByName.containsKey(name);
    }

    @Override
    public ArrayList<ReadableContent> buyByGenre(Genre genre) {
        return null;
    }

    @Override
    public ReadableContent buyByName(String name) {
        return null;
    }

    @Override
    public int sell(ReadableContent book) {
        return 0;
    }
}
