package cz.sspbrno.bookstore.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import cz.sspbrno.bookstore.Data;
import cz.sspbrno.bookstore.Market;
import cz.sspbrno.bookstore.books.Book;
import cz.sspbrno.bookstore.interfaces.BookHandler;
import cz.sspbrno.bookstore.interfaces.Day;
import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.staff.Customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class Store implements Serializable {
    @FXML
    private Label dayLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label title;

    @FXML
    private GridPane mainPane;

    @FXML
    private Label budgetLabel;
    
    private GridPane storePane;
    private GridPane marketPane;
    private ScrollPane customersPane;
    private ScrollPane bookSellPane;
    private ScrollPane storeBooksPane;

    private int budget = Data.STARTING_MONEY;
    private ArrayList<Book> storeBooks;
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
        randomCustomers();
        
        updateLabels();
    }

    private Day chooseNextDay() {
        switch (currentDay) {
            case PATEK:
                return Day.SOBOTA;
            case SOBOTA:
                return Day.NEDELE;
            case NEDELE:
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
    public void initialize() throws IOException {
        storeBooks = new ArrayList<>();
        calendar = Calendar.getInstance();
        currentDay = dayFromDate(calendar.getTime());
        customers = new ArrayList<>();
        market = new Market();
        random = new Random();

        randomCustomers();

        marketPane = new FXMLLoader(getClass().getClassLoader().getResource("market.fxml")).load();
        storePane = new FXMLLoader(getClass().getClassLoader().getResource("store.fxml")).load();

        for(Node node : marketPane.getChildren()){
            if(node.getId() != null){
            if(node.getId().equals("backButton")){
                Button b = ((Button) node);
                b.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        changeScene(storePane);
                        title.setText("Obchod");
                    updateLabels();
                }}); 
            }
            }
        }

        for(Node node : storePane.getChildren()){
            if(node.getId() != null){
                if(node.getId().equals("buyButton")){
                    Button b = ((Button) node);
                    b.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        changeScene(marketPane);
                        title.setText("Trh");
                        updateLabels();
                    }});
                }else if(node.getId().equals("customersPane")){
                    customersPane = (ScrollPane)node;
                } 
            }
        }

        changeScene(storePane);
        
        updateLabels();
    }

    public void randomCustomers(){
        customers.clear();
        for (int c = 0; c < random.nextInt(Data.MAX_CUSTOMERS); c++) {
            customers.add(new Customer());
        }
    }

    public void updateLabels(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dayLabel.setText(currentDay.name);
        dateLabel.setText(formatter.format(calendar.getTime()));
        budgetLabel.setText(" " + budget +" Kč");

        GridPane pane = new GridPane();

        for(int i = 0; i < customers.size(); i++){
            pane.add(customers.get(i), 1, i);
        }
        
        customersPane.setContent(pane);
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


    public void changeScene(Node scene){  
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.addAll(mainPane.getChildren());
        for(Node node : nodes){
            if(node.getId() != null && node.getId().equals(scene.getId())){
                mainPane.getChildren().remove(node);
            }
        }

        mainPane.add(scene, 0, 10, 20, 20);
    }
}
