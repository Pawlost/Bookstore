package cz.sspbrno.main;

import cz.sspbrno.main.staff.Customer;
import cz.sspbrno.main.staff.ShopAssistent;

import java.util.ArrayList;

public class BookStore {

    public static void main(String[] args){
        new BookStore();
    }

    private Store store;
    private ShopAssistent assistent;
    private ArrayList<Customer> customers;

    public BookStore() {
        store = new Store();
        assistent = new ShopAssistent();
        customers = new ArrayList<>();
        assistent = new ShopAssistent();

        for(int c = 0; c < Data.MAX_CUSTOMERS; c++){
            customers.add(new Customer());
        }
    }
}
