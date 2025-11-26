package javaExercises;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism {
    public static void main(String[] args) {
        List<Figura> figuras = new ArrayList<>();
        figuras.add(new Circulo(3));
        figuras.add(new Circulo(8));
        figuras.add(new Cuadrado(4));
        figuras.add(new Cuadrado(9));

        for(Figura f: figuras){
            f.dibujar();
            System.out.println("Area: " + f.calcularArea());
            System.out.println();
        }
    }
}
