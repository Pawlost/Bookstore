package cz.sspbrno.bookstore.books;

import cz.sspbrno.bookstore.interfaces.Genre;
import javafx.scene.control.Label;

public abstract class Content extends Label{
    public final String name;
    public final Genre genre;
    public final int price;
    private int count;

    public Content(String name, Genre genre, int price){
        super();
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.setText(toString());
    }

    public String toString(){
        if(count > 0){
            return "Název: " + name + " žánr: " + genre.name() + " cena: " + price +" a na skladě je "
            + count + " kusů";
        }else{
            return "Název: " + name + " žánr: " + genre.name() + " cena: " + price;
        }
    }

    public void setCount(int count){
        this.count = count;
        this.setText(toString());
    }
}
