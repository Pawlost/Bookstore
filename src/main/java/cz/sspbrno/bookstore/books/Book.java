package cz.sspbrno.bookstore.books;

import cz.sspbrno.bookstore.controllers.Store;
import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.staff.Person;

public class Book extends Content {
    private boolean electronic;
    private int pages;
    private Person author;
    private Store store;

    public Book(String name, Genre genre, int price, int pages, Person author, boolean electronic, Store store){
        super(name, genre, price);
        this.pages = pages;
        this.author = author;
        this.electronic = electronic;
        this.store = store;
    }

    @Override
    public void setStore(Store store){
        this.store = store;
    }

    @Override
    public Content clone(){
        return new Book(name, genre, price, pages, author, electronic, store);
    }

	@Override
	public void interact() {
        store.addBookToStore(this, author);
	}
}
