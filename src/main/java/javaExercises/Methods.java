package javaExercises;

public class Methods {
    public static void main(String[] args) {
        saludar("Alejandro");

        int resultado = sumar(10,10);
        System.out.println("Suma " + resultado);

        int resultado2 = sumar(20,43);
        System.out.println("Suma " + resultado2);

        int resultado3 = sumar(34,56);
        System.out.println("Suma " + resultado3);

        int resultado4 = sumar(34,56,90);
        System.out.println("Suma " + resultado4);
    }

    public static void saludar(String nombre){
        System.out.println("Hola, " + nombre + "!");
    }

    public static int sumar(int a, int b){
        return a + b;
    }

    public static int sumar(int a, int b, int c){
        return a + b + c;
    }
}
