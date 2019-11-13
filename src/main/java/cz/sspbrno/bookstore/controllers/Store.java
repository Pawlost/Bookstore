package cz.sspbrno.bookstore.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import cz.sspbrno.bookstore.Data;
import cz.sspbrno.bookstore.Market;
import cz.sspbrno.bookstore.interfaces.BookHandler;
import cz.sspbrno.bookstore.interfaces.Day;
import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.staff.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Store {
    @FXML
    private Label dayLabel;

    @FXML
    private Label dateLabel;
    
    private Market market;
    private BookHandler[] handlers;
    private Day currentDay;
    private Calendar calendar;
    private ArrayList<Customer> customers;
    private Random random;

    @FXML
    public void nextDay() {
        currentDay = chooseNextDay();
        calendar.add(Calendar.DAY_OF_WEEK, 1);
       for(Customer customer : customers) {
           // randomAction(customer);
        }
        
        updateLabels();
    }

    private Day chooseNextDay() {
        switch (currentDay) {
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

    @FXML
    public void initialize() {
        calendar = Calendar.getInstance();
        currentDay = dayFromDate(calendar.getTime());

        handlers = new BookHandler[2];
        customers = new ArrayList<>();
        market = new Market();
        handlers[1] = market;
        random = new Random();
        for (int c = 0; c < Data.MAX_CUSTOMERS; c++) {
            customers.add(new Customer());
        }

        updateLabels();
    }

    public void updateLabels(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dayLabel.setText(currentDay.name);
        dateLabel.setText(formatter.format(calendar.getTime()));
    }

    public Day dayFromDate(Date date){
        switch(date.getDay()){
            case 0:
                return Day.NEDELE;
            case 1:
                return Day.PONDELI;
            case 2:
            return Day.UTERY;
            case 3:
            return Day.STREDA;
            case 4:
            return Day.CTVRTEK;
            case 5:
            return Day.PATEK;
            case 6:
            return Day.SOBOTA;
        }
        return null;
    }

}
