package cz.sspbrno.bookstore.staff;

import java.util.ArrayList;

import cz.sspbrno.bookstore.Data;
import cz.sspbrno.bookstore.Market;
import cz.sspbrno.bookstore.books.Book;
import cz.sspbrno.bookstore.books.Content;
import cz.sspbrno.bookstore.interfaces.Genre;

public class Author extends Person {

    private ArrayList<Book> releasedBooks;
    public static final String[] BOOK_NAMES = new String[]{"HA","HHH", "HMMMM", "HCH"};

    public Author(String firstName, String lastName, int age, int money){
        super(firstName, lastName, age, money);
    }

    @Override
    public void makeMoney(int money) {

    }

    @Override
    public void spendMoney(int money) {

    }

    public Content releaseRandomBook(Market market){
            String bookName = BOOK_NAMES[random.nextInt(BOOK_NAMES.length)];
            if(!market.isBookOnMarket(bookName)) {
                Genre genre = Genre.values()[random.nextInt(Genre.values().length)];
                return new Book(bookName, genre, random.nextInt(Data.MAX_BOOK_PAGES) + 1,
                        random.nextInt(Data.MAX_BOOK_PAGES) + 1, this, random.nextBoolean());
            }
        return null;
    }

    public Content releaseBook(String name, Genre genre, int pages, int price) {
        return new Book(name, genre, pages, price,this, random.nextBoolean());
    }

    @Override
    public boolean decide() {
        return false;
    }

	@Override
	public void interact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateText() {
		// TODO Auto-generated method stub
		
	}
}
