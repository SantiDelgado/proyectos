package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante>estudiantes = new ArrayList<>();

    //Crear menu de opciones
        int opcion;
        do {
            System.out.println(" GESTION DE ESTUDIANTES");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Mostrar todos los estudiantes");
            System.out.println("3. Salir");
            System.out.println("Ingrese opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1: //Asignar nuevo estudiante
                    System.out.println("ingresar del estudiante: ");

                    System.out.println("Ingrese identificacion: ");
                    int identificacion = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingrese el apellido del estudiante: ");
                    String apellido = scanner.nextLine();

                    System.out.println("Ingrese el correo del estudiante: ");
                    String correo = scanner.nextLine();

                    System.out.println("Ingrese el edad del estudiante: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingrese el telefono del estudiante: ");
                    long telefono = scanner.nextLong();
                    scanner.nextLine();

                    //Crear estudiante a la lista
                    estudiantes.add(new Estudiante(identificacion, nombre, apellido, correo, edad, telefono));
                    System.out.println("Estudiante agregado correctamente");
                    break;

                    //mostrar los estudiantes
                case 2:
                        if (estudiantes.isEmpty()) { //is.Empty ayuda a saber si hay elementos en la lista si
                                                    // no hay elementos retorna true, si hay elementos retorna false
                            System.out.println("No existe ningun estudiante registrado");
                        } else {
                            System.out.println("\nLista de estudiantes:");
                            for (int i = 0; i < estudiantes.size(); i++) {
                                System.out.println((i + 1) + ". " + estudiantes.get(i));// imprime un indice antes de
                                                                            // cada estudiante porque va recorriendo por indice de la lista
                                                                            //.size es para tener el tamaño de la lista
                            }                                              //.get(i) obtiene el estudiante 1 de la lista
                            /**
                             * int contador = 1;
                             * for (Estudiante est : estudiantes) {
                             *     System.out.println(contador + ". " + est);
                             *     contador++;
                             * }
                             * imprimir por lista con el for each
                             */
                        }
                        break;

                case 3: // finalizar el menu
                    System.out.println("saliendo del programa");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;



            }
        } while (opcion != 3);
        scanner.close(); // si la opcion es 3, el bucle termina pero si no es 3, el menu se vuelve a mostrar hasta que sea la opciom 3


    }
}