package javaExercises;

public class Constructors {

    public static void main(String[] args) {
        Alumno alex = new Alumno("Alex",34);
        alex.presentarse();

        Alumno luis = new Alumno("Luis",28);
        luis.presentarse();

        Alumno carlos = new Alumno("Carlos",28, "Java");
        carlos.edad = 35;
        carlos.presentarse();
        carlos.materiaFavorita();
    }
}

class Alumno{
    String nombre;
    int edad;
    String materia;

    public Alumno(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public Alumno(String nombre, int edad, String materiaFavorita){
        this.nombre = nombre;
        this.edad = edad;
        this.materia = materiaFavorita;
    }

    public void presentarse(){
        System.out.println("Hola soy " + nombre + " y tengo " + edad + " años de edad.");
    }

    public void materiaFavorita(){
        System.out.println("Mi materia faorita es: " + materia);
    }
}
