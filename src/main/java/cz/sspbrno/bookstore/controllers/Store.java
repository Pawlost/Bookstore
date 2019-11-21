package cz.sspbrno.bookstore.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import cz.sspbrno.bookstore.Data;
import cz.sspbrno.bookstore.Market;
import cz.sspbrno.bookstore.staff.*;
import cz.sspbrno.bookstore.books.Content;
import cz.sspbrno.bookstore.interfaces.Day;
import cz.sspbrno.bookstore.staff.Customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import cz.sspbrno.bookstore.*;


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
    private ScrollPane authorsPane;
    private ScrollPane storeBooksPane;
    private ScrollPane sortedBooks;

    private int budget;
    private HashMap<Content, Integer> storeBooks;
    private Market market;
    private Day currentDay;
    private Calendar calendar;
    private ArrayList<Customer> customers;
    private Random random;

    @FXML
    public void nextDay() {
        currentDay = chooseNextDay();
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        randomCustomers(market.getAllBooks());
        
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

    @FXML
    public void initialize() throws IOException {
        storeBooks = new HashMap<>();
        calendar = Calendar.getInstance();
        currentDay = dayFromDate(calendar.getTime());
        customers = new ArrayList<>();
        market = new Market(this);
        random = new Random();
        budget = Data.STARTING_MONEY;

        randomCustomers(market.getAllBooks());

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
            } else if(node.getId().equals("authors")){
                authorsPane = (ScrollPane) node;
            }else if(node.getId().equals("sortedBooks")){
                sortedBooks = (ScrollPane) node;
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
                }else if(node.getId().equals("bookPane")){
                    storeBooksPane = (ScrollPane)node;
                } 
            }
        }

        changeScene(storePane);
        
        updateLabels();
    }

    public void randomCustomers(ArrayList<Content> allBooks){
        customers.clear();
        for (int c = 0; c < random.nextInt(Data.MAX_CUSTOMERS); c++) {
            int index = random.nextInt(allBooks.size());
            Customer customer = new Customer(allBooks.get(index));
            customer.setStore(this);
            customers.add(customer);
        }
    }

    public void updateLabels(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        dayLabel.setText(currentDay.name);
        dateLabel.setText(formatter.format(calendar.getTime()));
        budgetLabel.setText(" " + budget +" Kč");

        GridPane pane = new GridPane();

        for(int i = 0; i < customers.size(); i++){
            pane.add(customers.get(i), 1, i);
        }

        customersPane.setContent(pane);

        pane = new GridPane();

        for(int i = 0; i < market.getAuthors().size(); i++){
            pane.add(market.getAuthors().get(i), 1, i);
        }
        
        authorsPane.setContent(pane);

        pane = new GridPane();

        ArrayList<Content> books = new ArrayList<>(storeBooks.keySet());
        for(int i = 0; i < books.size(); i++){
            books.get(i).removeParent();
            pane.add(books.get(i).clone(), 1, i);
        }
        
        storeBooksPane.setContent(pane);

        pane = new GridPane();

        for(int i = 0; i < market.getAllBooks().size(); i++){
            market.getAllBooks().get(i).setStore(this);
            pane.add(market.getAllBooks().get(i), 1, i);
        }
        
        sortedBooks.setContent(pane);
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
        updateLabels();
    }

    public void addBookToStore(Content content, Person author){
        if(budget > content.price){
            budget -= content.price;
            author.makeMoney(content.price);
            if(!storeBooks.keySet().contains(content)){
                storeBooks.put(content, 1);
            }else{
                int count = storeBooks.get(content) + 1;
                content.setCount(count);
                storeBooks.put(content, count);
            }
            updateLabels();
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Nedostatek peněz");
            alert.setHeaderText("Nemáš dost peněz na nakoupení knihy");
            alert.showAndWait();
         }
    }

    public void buyBook(Content content, Customer customer){
        if(storeBooks.keySet().contains(content) && customer.getMoney() > content.price + 100){
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Prodat knihu");
            alert.setHeaderText(content.toString());
            alert.setContentText("Opravdu chceš prodat tuto knihu " + customer.toString() + " ?");

            java.util.Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                int count = storeBooks.get(content) - 1;
                storeBooks.put(content, count);
                budget += content.price + 100;
                customer.spendMoney(content.price + 100);
                if(storeBooks.get(content) == 0){
                    storeBooks.remove(content);
                }
                customers.remove(customer);
                updateLabels();
            }
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Nelze prodat knihu");
            alert.setHeaderText("Kniha není na skladě, anebo zákaznik nemá dost peněz");
            alert.showAndWait();
         }
    }

    public void exitApplication() {
        ArrayList<Serializable> array = new ArrayList<>();

        for(Author author : market.getAuthors()){
            author.removeParent();
            array.add(author);
        }
        Serialization.serialize(Data.AUTHORS_PATH, array);
        array.clear();

        for(Content book : market.getAllBooks()){
            book.removeParent();
            array.add(book);
        }
        Serialization.serialize(Data.BOOKS_PATH, array);
        array.clear();
    }
}
