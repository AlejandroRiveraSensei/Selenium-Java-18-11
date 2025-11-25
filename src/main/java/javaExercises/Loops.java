package javaExercises;

import java.util.Arrays;
import java.util.List;

public class Loops {

    public static void main(String[] args) {
        // for
        System.out.println("Ciclo for:");
        for (int i = 1; i <= 5;i++){
            System.out.println("Iteracion: " + i);
        }

        // while
        System.out.println();
        System.out.println("Ciclo while:");
        int j = 1;
        while (j <= 5){
            System.out.println("Contador: " + j);
            j++;
        }

        // do while
        System.out.println();
        System.out.println("Ciclo do-while:");
        int k = 7;
        do{
            System.out.println("Numero: " + k);
            k++;
        }while(k <= 5);

        // for-each
        System.out.println();
        System.out.println("Ciclo for-each:");
        List<String> frutas = Arrays.asList("Manzanas" , "Banana", "Cereza");
        for (String fruta: frutas ){
            System.out.println("La fruta es: " + fruta);
        }

    }
}
