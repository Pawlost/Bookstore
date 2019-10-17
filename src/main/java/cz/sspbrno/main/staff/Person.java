package cz.sspbrno.main.staff;

import cz.sspbrno.main.Data;

import java.util.Random;

public abstract class Person{
    protected String firstName;
    protected String lastName;
    protected int age;
    protected Random random;

    public Person(String lastName, String firstName, int age){
        random = new Random();
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public Person(){
        random = new Random();
        firstName = Data.FIRST_NAMES[random.nextInt(Data.FIRST_NAMES.length)];
        lastName = Data.LAST_NAMES[random.nextInt(Data.LAST_NAMES.length)];
        age = random.nextInt(Data.OLDEST_AGE - Data.YOUNGEST_AGE) + Data.YOUNGEST_AGE;
    }

    public String toString(){
        return "Jméno: " + firstName +" "+lastName +", věk: "+age;
    }
}
