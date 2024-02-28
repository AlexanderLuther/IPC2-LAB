package main;

import controllers.BinaryFileController;
import controllers.FileController;
import dto.Vehicle;

public class Main {
    public static void main(String[] args) {

        FileController fileController = new FileController();
        BinaryFileController binaryFileController = new BinaryFileController();

        String  fileName = "./archivo.bin";

        binaryFileController.write(
                fileName,
                Vehicle.builder()
                        .color("red")
                        .model(1990)
                        .owner("Alexander")
                        .build()
        );

        binaryFileController.read(fileName);


        //fileController.create(fileName);
        //fileController.write(fileName, "Texto a ser agregado debajo del texto inicial", true);
        // fileController.write(fileName, "Texto que sera sobreescrito", false);
        //fileController.read(fileName);
    }
}