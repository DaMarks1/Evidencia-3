import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universidad universidad = new Universidad();
        int opcion = 0;
        String nombre = "";
        int edad = 0;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar todos los estudiantes");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Agregar materia y calificacion");
            System.out.println("5. Salir del sistema");


            System.out.println("Elije una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("AGREGAR ESTUDIANTE");

                    try {
                        System.out.println("Ingrese el nombre del estudiante: ");
                        nombre = scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }

                    try {
                        System.out.println("Ingresa la edad del estudiante:");
                        edad = scanner.nextInt();
                        scanner.nextLine();
                    }catch (Exception e) {
                        System.out.println("ERROR: LA EDAD SOLO DEBE TENER NUMEROS ENTEROS");
                        scanner.nextLine();
                    }

                    if (!nombre.isEmpty() && edad > 0) {
                        universidad.agregarEstudiante(nombre, edad);
                        System.out.println("Estudiante agregado: " + nombre);
                    }else {
                        System.out.println("No se pudo agregar al estudiante");
                    }

                    break;

                case 2:
                    System.out.println("MOSTRAR ESTUDIANTES");
                    universidad.mostrarEstudiantes();
                    break;

                case 3:
                    System.out.println("BUSCAR ESTUDIANTE");
                    System.out.print("Ingrese el nombre del estudiante a buscar: ");
                    nombre = scanner.nextLine();
                    universidad.buscarEstudiante(nombre);

                    break;

                case 4:
                    System.out.println("Ingrese el nombre del estudiante");
                    String nombreEstudiante = scanner.nextLine();

                    if (universidad.getEstudiantes().containsKey(nombreEstudiante)){
                        System.out.print("Ingrese el nombre de la materia: ");
                        String nombreMateria = scanner.nextLine();
                        System.out.println("Ingrese calificacion de la materia (1-100)");
                        double calificacion = scanner.nextDouble();
                        scanner.nextLine();

                        try {
                            universidad.getEstudiantes().get(nombreEstudiante).agregarMateria(nombreMateria, calificacion);
                            System.out.println("Materia y calificación agregadas con éxito.");
                        }catch (CalificacionInvalidaException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }catch (Exception e) {
                        System.out.println("ERROR: ocurrio un error");
                        }

                    }else {
                        System.out.println("El estudiante no existe");
                    }
                    break;


                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
                    break;
            }

        }while (opcion != 5);

    }
}