package cz.sspbrno.main;

import cz.sspbrno.main.interfaces.Day;
import cz.sspbrno.main.staff.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {

    public static void main(String[] args) {
        new BookStore();
    }

    private Market market;
    private Store store;
    private Day day;
    private ArrayList<Customer> customers;

    public BookStore() {
        day = Day.PATEK;
        store = new Store();
        customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        market = new Market();

        while (!scanner.nextLine().equals("")) {
            nextDay();
        }
    }

    private void nextDay() {
        day = chooseNextDay(day);

        for (int c = 0; c < Data.MAX_CUSTOMERS; c++) {
            customers.add(new Customer());
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
}
