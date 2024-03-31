package main;

import java.util.List;

public class main {

    public static void main(String[] args) {

        List<Integer> numeros = List.of(12, 45, 67, 87, 5, 1, 34, 90, 3, 4);


        //PROGRAMACION IMPERATIVA
        int counter = 0;
        for(int number : numeros){
            if(number > 10){
                counter++;
            }
        }
        System.out.println(counter);


        //PROGRAMACION DECLARATIVA(FUNCIONAL)
        Long counter2 = numeros.stream().filter(num -> num > 10).count();
        System.out.println(counter2);


        numeros.forEach(item -> System.out.println(item));

        numeros.stream()
                .filter(item -> item > 40)
                .forEach(item -> System.out.println(item));

        numeros.stream()
                .sorted((n1, n2) -> -(n1.compareTo(n2)))
                .forEach(item -> System.out.println(item));
    }
}
