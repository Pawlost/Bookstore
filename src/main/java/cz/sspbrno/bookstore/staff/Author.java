package cz.sspbrno.bookstore.staff;

import cz.sspbrno.bookstore.controllers.*;
import cz.sspbrno.bookstore.books.Content;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class Author extends Person implements Serializable {

    private Content currentContent;
    private Store store;
    private HashMap<String, Content> releasedBooks;
    public static final String[] BOOK_NAMES = new String[]{"HA","HHH", "HMMMM", "HCH"};

    public Author(String firstName, String lastName, int age, int money){
        super(firstName, lastName, age, money);
        releasedBooks = new HashMap<>();
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public void makeMoney(int money) {
        this.money += money;
    }

    @Override
    public void spendMoney(int money) {
        this.money -= money;
    }

    public void addContent(Content content) {
        releasedBooks.put(content.toString(), content);
    }

	@Override
	public void interact() {
        if(releasedBooks.size() > 0){
        List<String> books = new ArrayList<>();
        for(String key : releasedBooks.keySet()){
            books.add(key);
        }
        ChoiceDialog<String> cDialog = new ChoiceDialog<>(books.get(0), books);
        cDialog.setTitle("Koupit knihu");
        cDialog.setHeaderText("Autor: " + toString() + " vydal tyto knihy: ");	
        cDialog.setContentText("Vyber si knihu: ");
        Optional<String> result = cDialog.showAndWait();
        if (result.isPresent()){
            Content content = releasedBooks.get(result.get());
            store.addBookToStore(content, this);
        }
    }else{
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Kniha nenalezena");
        alert.setHeaderText("Tento autor zatím nevydal žádnou knihu");
        alert.showAndWait();
        }
    }

	@Override
	public String toString() {
        return "Jméno: " + firstName +" "+lastName +", věk: "+age +" peníze: " + money;
	}

	@Override
	public void updateText() {
        this.setText(this.toString());
    }
    
    public Content getCurrentContent(){
        return currentContent;
    }

    public void removeParent(){
        ((Pane)this.getParent()).getChildren().remove(this);
    }
}
