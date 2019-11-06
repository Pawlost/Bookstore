package cz.sspbrno.bookstore;

import cz.sspbrno.bookstore.interfaces.BookHandler;
import cz.sspbrno.bookstore.interfaces.Day;
import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.staff.Customer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BookStore {

    private Market market;
    private BookHandler[] handlers;
    private Day day;
    private ArrayList<Customer> customers;
    private Random random;

    public BookStore() {
        day = Day.PATEK;
        handlers = new BookHandler[2];
        handlers[0] = new Store();
        customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        market = new Market();
        handlers[1] = market;
        random = new Random();
        for (int c = 0; c < Data.MAX_CUSTOMERS; c++) {
            customers.add(new Customer());
        }

        while (!scanner.nextLine().equals("")) {
            nextDay();
        }
    }

    private void nextDay() {
        day = chooseNextDay(day);
        for(Customer customer : customers) {
            randomAction(customer);
        }
    }

    private static Day chooseNextDay(Day day) {
        switch (day) {
            case PATEK:
                return Day.PONDELI;
            case PONDELI:
                return Day.UTERY;
            case UTERY:
                return Day.STREDA;
            case STREDA:
                return Day.CTVRTEK;
            case CTVRTEK:
                return Day.PATEK;
        }
        return null;
    }

    private void randomAction(Customer customer){
        BookHandler handler = handlers[random.nextInt(1)];
        customer.makeMoney(random.nextInt(market.getMarketMoney()));
        switch (random.nextInt(1)){
            case 0:
                int genre  = random.nextInt(Genre.values().length);
                handler.getByGenre(Genre.values()[genre]);
                break;
            case 1:
                break;
        }
    }
}
