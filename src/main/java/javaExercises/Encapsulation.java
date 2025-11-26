package javaExercises;

public class Encapsulation {
    public static void main(String[] args) {
        Persona persona = new Persona("Alejandro", 34);
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());

        persona.setEdad(35);
        System.out.println("Edad Actualizada: " + persona.getEdad());

    }
}

class Persona{
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    //Getters / Setters
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        if(edad > 0){
            this.edad = edad;
        }
    }

}
