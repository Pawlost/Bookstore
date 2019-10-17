package cz.sspbrno.main.staff;

import cz.sspbrno.main.Data;

import java.util.Random;

public abstract class Person{
    private String firstName;
    private String lastName;
    int age;
    int money;
    Random random;
    Personality personality = Personality.NORMAL;

    Person(String lastName, String firstName, int age){
        random = new Random();
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    Person(){
        random = new Random();
        firstName = Data.FIRST_NAMES[random.nextInt(Data.FIRST_NAMES.length)];
        lastName = Data.LAST_NAMES[random.nextInt(Data.LAST_NAMES.length)];
        age = random.nextInt(Data.OLDEST_AGE - Data.YOUNGEST_AGE) + Data.YOUNGEST_AGE;
        personality = Personality.values()[random.nextInt(Personality.values().length)];
    }

    public abstract void makeMoney(int money);

    public abstract void spendMoney(int money);

    public String toString(){
        return "Jméno: " + firstName +" "+lastName +", věk: "+age;
    }
}
