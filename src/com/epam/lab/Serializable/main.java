package com.epam.lab.Serializable;


import java.io.*;

public class main implements Serializable {
    public static void main(String[] args) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Droid.dat"))) {

            DroidsContainer<? super Droid> droidDroidContainer = new DroidsContainer<>();
            droidDroidContainer.put(new Droid("Hugo", 12,80));
            droidDroidContainer.put(new Droid("Marsel", 14, 40));
            oos.writeObject(droidDroidContainer);
        }catch(Exception ex){
            System.out.println("Error");
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Droid.dat")))
        {
            DroidsContainer<? super Droid> droidDroidContainer=(DroidsContainer)ois.readObject();
            droidDroidContainer.print();
        }
        catch(Exception ex){
            System.out.println("Error");
        }

    }

}
