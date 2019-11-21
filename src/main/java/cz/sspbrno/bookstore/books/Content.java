package cz.sspbrno.bookstore.books;

import java.io.Serializable;

import cz.sspbrno.bookstore.controllers.Store;
import cz.sspbrno.bookstore.interfaces.Genre;
import cz.sspbrno.bookstore.interfaces.Interactable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public abstract class Content extends Button implements Interactable, Serializable, Cloneable {
    public final String name;
    public final Genre genre;
    public final int price;
    private int count;

    public Content(String name, Genre genre, int price) {
        super();
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.setText(toString());

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                interact();
                updateText();
            }
        });
    }

    public String toString() {
        if (count > 0) {
            return "Název: " + name + " žánr: " + genre.name() + " cena: " + price + " a na skladě je "
                    + count + " kusů";
        } else {
            return "Název: " + name + " žánr: " + genre.name() + " cena: " + price;
        }
    }

    public void setCount(int count) {
        this.count = count;
        this.setText(toString());
    }

    @Override
    public void updateText() {
        this.setText(this.toString());
    }

    @Override
    public abstract void interact();

    @Override
    public abstract void setStore(Store store);

    @Override
    public abstract Content clone();

    public void removeParent() {
        ((Pane) this.getParent()).getChildren().remove(this);
    }
}
