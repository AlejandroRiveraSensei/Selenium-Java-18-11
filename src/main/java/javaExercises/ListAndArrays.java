package javaExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAndArrays {

    public static void main(String[] args) {
        //Arreglo fijo
        String color1 = "Rojo";
        String color2 = "Verde";
        String[] colores = {"Rojo", "Verde", "Azul"};
        System.out.println("Arreglo:");
        System.out.println(colores[2]);
        for (int i = 0; i < colores.length; i++){
            System.out.println("Color[" + i + "]: " + colores[i]);
        }

        //Lista dinamica
        List<String> animales = new ArrayList<>();
        animales.add("Perro");
        animales.add("Gato");
        animales.add("Loro");

        System.out.println();
        System.out.println("Lista:");
        for (String animal : animales){
            System.out.println("Animal: " + animal);
        }

        animales.remove("Gato");
        animales.add("Conejor");
        System.out.println("Lista Modificada:");
        for (String animal : animales){
            System.out.println("Animal: " + animal);
        }

        //Convertir arreglo a lista
        List<String> coloresList = Arrays.asList(colores);
        System.out.println();
        System.out.println("List desde arreglo:");
        coloresList.forEach(System.out::println);
    }
}
