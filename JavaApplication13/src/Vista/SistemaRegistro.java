package vista;

import controlador.GestionLenguaje;
import modelo.LenguajeProgramacion;

import java.util.Scanner;

public class SistemaRegistro {
    private static GestionLenguaje gestionLenguaje = new GestionLenguaje();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Bienvenido al sistema de registro de lenguajes de programacion!");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Agregar un nuevo lenguaje");
            System.out.println("2. Buscar un lenguaje por nombre");
            System.out.println("3. Eliminar un lenguaje");
            System.out.println("4. Ver todos los lenguajes registrados");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el anio de creacion: ");
                    int anioCreacion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingresa la caracteristica principal: ");
                    String caracteristicaPrincipal = scanner.nextLine();
                    System.out.print("Ingresa el nombre del lenguaje: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingresa el uso principal del lenguaje: ");
                    String utilizacion = scanner.nextLine();

                    gestionLenguaje.agregarLenguaje(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
                    System.out.println("Lenguaje agregado exitosamente!");
                    break;

                case 2:
                    System.out.print("Ingresa el nombre del lenguaje que quieres buscar: ");
                    String buscarNombre = scanner.nextLine();
                    LenguajeProgramacion lenguajeEncontrado = gestionLenguaje.buscarLenguaje(buscarNombre);

                    if (lenguajeEncontrado != null) {
                        System.out.println("Lenguaje encontrado: " + lenguajeEncontrado);
                    } else {
                        System.out.println("No se encontro ningun lenguaje con ese nombre.");
                    }
                    break;

                case 3:
                    System.out.print("Ingresa el nombre del lenguaje que quieres eliminar: ");
                    String eliminarNombre = scanner.nextLine();
                    boolean eliminado = gestionLenguaje.eliminarLenguaje(eliminarNombre);

                    if (eliminado) {
                        System.out.println("Lenguaje eliminado exitosamente.");
                    } else {
                        System.out.println("No se encontro ningun lenguaje con ese nombre.");
                    }
                    break;

                case 4:
                    gestionLenguaje.imprimirLenguajes();
                    break;

                case 5:
                    System.out.println("Gracias por usar el sistema. Hasta pronto!");
                    break;

                default:
                    System.out.println("Opcion invalida. Por favor intenta de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}