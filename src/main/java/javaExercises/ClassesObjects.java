package javaExercises;

public class ClassesObjects {

    public static void main(String[] args) {
        //Instancia de classes / Aqui creamos los objetos de la clase Bartender
        Bartender b1 = new Bartender();
        Bartender b2 = new Bartender();

        //Comportamoentos o metodos de bartender
        b1.presentarse("Luis","tropical");
        b1.servirBebida("Mojito","Luis","tropical");

        b2.presentarse("Ana", "clasico");
        b2.servirBebida("Old Fashion","Ana","Clasico");
    }
}

class Bartender{

    //Metodo: Comportamiento/Accion del bartender
    public void servirBebida(String bebida, String nombre, String estilo){
        System.out.println(nombre + " sirve un(a) " + bebida + " con estilo " + estilo + ".");
    }

    //Otro comportamiento/metodo
    public void presentarse (String nombre, String estilo){
        System.out.println("Soy " + nombre + ", tu bartender especializado en " + estilo + ".");
    }
}
