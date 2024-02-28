package controllers;

import dto.Vehicle;
import java.io.*;

public class BinaryFileController {

    public void write(String name, Vehicle vehicle){
        try {
            File file = new File(name);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(vehicle);
            objectOutputStream.close();
            System.out.println("Vehiculo almacenado");
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }

    public void read(String name){
        try {
            File file = new File(name);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Vehicle vehicle = (Vehicle) objectInputStream.readObject();
            System.out.println(vehicle.toString());
            objectInputStream.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");
        }
    }

}
