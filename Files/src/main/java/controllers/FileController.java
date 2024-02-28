package controllers;

import java.io.*;

public class FileController {


    public void create(String name){
        File file = new File(name);
        try {
            if(file.createNewFile()){
                System.out.println("Archivo creado");
            } else {
                System.out.println("Error al crear archivo");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String name){
        File file = new File(name);
        if(file.delete()){
            System.out.println("Archivo borrado");
        } else {
            System.out.println("Error al borrar");
        }
    }

    public void showFileData(String name) {
        File file = new File(name);
        System.out.println("Path absoluto " + file.getAbsolutePath());
        System.out.println("Path ralativo " + file.getPath());
        System.out.println("Existe? " + file.exists());
    }


    public void read(String name){
        File file = new File(name);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    public void write(String name, String data, boolean append){
        File file = new File(name);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(data);
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }

    }

}
