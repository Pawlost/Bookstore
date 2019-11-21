package cz.sspbrno.bookstore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Serialization {
    public static void serialize(String path, ArrayList<Serializable> objects){
        try {
            FileOutputStream fileOut =
            new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for(Serializable serializable : objects){
                out.writeObject(serializable);
            }
            out.close();
            fileOut.close();
         } catch (IOException i) {
            i.printStackTrace();
         }
    }

    public static ArrayList<Object> deserialize(String path) {
        ArrayList<Object> array = new ArrayList<>();
        try {
           FileInputStream fileIn = new FileInputStream(path);
           ObjectInputStream in = new ObjectInputStream(fileIn);
           array.add(in.readObject());
           in.close();
           fileIn.close();
        } catch (Exception i) {
           i.printStackTrace();
        }
        return array;
     }
}