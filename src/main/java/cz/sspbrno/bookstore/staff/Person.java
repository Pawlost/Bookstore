package cz.sspbrno.bookstore.staff;

import java.util.Random;

import cz.sspbrno.bookstore.Data;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class Person extends Button implements Decide {
    String firstName;
    String lastName;
    int age;
    int money;
    Random random;
    Personality personality = Personality.NORMAL;

    Person(String lastName, String firstName, int age, int money){
        super();
        random = new Random();
        init(lastName, firstName, age, money);
    }

    Person(){
        super();
        random = new Random();
        firstName = Data.FIRST_NAMES[random.nextInt(Data.FIRST_NAMES.length)];
        lastName = Data.LAST_NAMES[random.nextInt(Data.LAST_NAMES.length)];
        age = random.nextInt(Data.OLDEST_AGE - Data.YOUNGEST_AGE) + Data.YOUNGEST_AGE;
        personality = Personality.values()[random.nextInt(Personality.values().length)];
        money = random.nextInt(Data.MAX_MONEY_AMOUNT);
        init(lastName, firstName, age, money);
    }

    private void init(String lastName, String firstName, int age, int money){
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
               interact();
               updateText();
            }
        }); 

        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;  
        this.money = money;   
        updateText(); 
    }

    public void updateText(){
        this.setText(this.toString());
    }

    public abstract void makeMoney(int money);

    public abstract void spendMoney(int money);

    public abstract void interact();

    public abstract String toString();
}
