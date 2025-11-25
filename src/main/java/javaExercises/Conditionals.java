package javaExercises;

public class Conditionals {

    public static void main(String[] args) {
        int edad = 21;
        //if
        if (edad >= 18){
            System.out.println("Eres mayor de edad");
        }

        //if-else
        if(edad < 18){
            System.out.println("Eres menor de edad");
        }else{
            System.out.println("Tienes al menos 18 años");
        }

        //if-else-if
        int calificacion = 20;
        if(calificacion >= 90){
            System.out.println("Excelente");
        } else if(calificacion >= 80){
            System.out.println("Muy bien");
        } else if (calificacion >=70){
            System.out.println("Bien");
        } else {
            System.out.println("Requiere mejora");
        }

        //if anidado
        boolean tieneCuenta = false;
        boolean tieneFondos = false;

        if(tieneCuenta){
            if(tieneFondos){
                System.out.println("Puedes hacer una compra");
            } else{
                System.out.println("No tienes fondos suficientes");
            }
        }else{
            System.out.println("No tienes cuenta registrada");
        }

        //Switch
        int diasSemana = 8;
        switch (diasSemana){
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sabado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("No hay mas de 7 dias de la semana");
                break;
        }

        //Operador ternario
        String mensaje = (edad >= 18) ? "Adulto" : "Menor de edad";
        System.out.println("Ternario: " + mensaje);
    }
}
