package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Children>boys = new ArrayList<>();

        //Menu
        int opc;
        do {

            System.out.println("Ingrese una opcion: ");
            System.out.println("1. Agregar niño.");
            System.out.println("2. Eliminar niño.");
            System.out.println("3. Mostrar lista de niños.");
            System.out.println("4. Modificar datos de un niño.");
            System.out.println("5. Mostrar el nombre del niño con más vocales.");
            System.out.println("6. Mostrar el niño que tenga un nombre palíndromo.");
            System.out.println("7. Moatrar el nombre del niño con más consonantes.");
            System.out.println("8. Eliminar las vocales de los nombres de todos los niños.");
            System.out.println("9. Salir");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    agregarBoy(boys, scanner);
                    break;

                case 2:
                    eliminarBoy(boys, scanner);
                    break;
                case 3:
                    mostrarLista(boys);
                    break;
                case 4:
                    modificarBoy(boys, scanner);
                    break;
                case 5:
                    String nombreMasVocales = nombreMasVocales(boys);
                    System.out.println("El nombre con más vocales es: " + nombreMasVocales);
                    break;
                case 6:
                    ArrayList<String> nombresPalindromos = encontrarNombresPalindromos(boys);
                    System.out.println("Los nombres palíndromos son: " + nombresPalindromos);
                    break;
                case 7:
                    String nombreConMasConsonantes = nombreConMasConsonantes(boys);
                    System.out.println("El nombre con más consonantes es: " + nombreConMasConsonantes);
                    break;
                case 8:
                    eliminarVocales(boys);
                    // Mostrar la lista actualizada
                    for (Children child : boys) {
                        System.out.println(child.getNombre());
                    }
                    break;
                case 9:
                    System.out.println("\n----Saliendo del sistema----");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        } while (opc != 9);
        scanner.close();
    }
    public static void agregarBoy(ArrayList<Children>boys, Scanner scanner) {
        System.out.println("Ingrese datos del niño: ");

        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el genero: ");
        String genero = scanner.nextLine();

        System.out.println("Ingrese la identificacion: ");
        String identificacion = scanner.nextLine();

        System.out.println("Ingrese las alergias (en caso de no tener colocar No aplica: ");
        String alergias = scanner.nextLine();

        System.out.println("Ingresar nombre del acudiente: ");
        String nombreAcudiente = scanner.nextLine();

        System.out.println("Ingresar el numero del acudiente: ");
        String numeroAcudiente = scanner.nextLine();

        boys.add(new Children(nombre, edad, genero, identificacion,
                alergias, nombreAcudiente, numeroAcudiente ));
        System.out.println("Niño agregado.");
    }
    public static void eliminarBoy(ArrayList<Children>boys, Scanner scanner) {
        System.out.println("\n--------Eliminar niño------");
        System.out.println("Ingrese la identificacion: ");
        String identificacion = scanner.nextLine();

        Children boyAEliminar = new Children("", 0, "", identificacion, "",
                "", ""); // crear niño para buscar
        if(boys.contains(boyAEliminar)) {
            boys.remove(boyAEliminar);
            System.out.println("El niño fue elminado correctamente.");
        }else{
            System.out.println("El niño no esta en la lista.");
        }

    }
    public static void mostrarLista(ArrayList<Children>boys) {
            System.out.println("\n--- Lista de Niños ---");
            if (boys.isEmpty()) {
                System.out.println("No hay niños matriculados.");
            } else {
                for (Children child : boys) {
                    System.out.println(child);
                }
            }
    }
    public static void modificarBoy(ArrayList<Children>boys, Scanner scanner) {
            System.out.println("\n--- Modificar Niño ---");
            System.out.print("Ingresa el documento de identidad del niño a modificar: ");
            String id = scanner.nextLine();

            // Buscar al niño en la lista
            Children childAModificar = null;
            for (Children child : boys) {
                if (child.getIdentificacion().equals(id)) {
                    childAModificar = child;
                    break; // Salir del bucle cuando se encuentra el niño
                }
            }
        // Si se encontró al niño, modificar sus datos
        if (childAModificar != null) {
            System.out.println("Datos actuales del niño:");
            System.out.println(childAModificar);

            System.out.println("\nIngresa los nuevos datos:");

            System.out.print("Nombre: ");
            childAModificar.setNombre(scanner.nextLine());

            System.out.print("Edad: ");
            childAModificar.setEdad(scanner.nextInt());
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Género: ");
            childAModificar.setGenero(scanner.nextLine());

            System.out.println("Identificacion: ");
            childAModificar.setIdentificacion(scanner.nextLine());

            System.out.print("Alergias: ");
            childAModificar.setAlergias(scanner.nextLine());

            System.out.print("Nombre del acudiente: ");
            childAModificar.setNombreAcudiente(scanner.nextLine());

            System.out.print("Número de contacto: ");
            childAModificar.setNumeroAcudiente(scanner.nextLine());

            System.out.println("Niño modificado correctamente.");
        } else {
            System.out.println("No se encontró un niño con ese documento de identidad.");
        }


    }
    public static String nombreMasVocales(ArrayList<Children>boys) {
        String nombreMaxVocales = ""; // Almacena el nombre con más vocales
        int maxVocales = 0; // Almacena la cantidad máxima de vocales encontradas

        // Recorrer la lista de niños
        for (Children child : boys) {
            String nombre = child.getNombre();
            int contadorVocales = contarVocales(nombre);

            // Si el nombre actual tiene más vocales, actualizar el máximo
            if (contadorVocales > maxVocales) {
                maxVocales = contadorVocales;
                nombreMaxVocales = nombre;
            }
        }
        return nombreMaxVocales;
    }
    public static int contarVocales(String nombre) {
        int contadorVocales = 0;
        String nombreMinusculas = nombre.toLowerCase(); // Convertir a minúsculas para simplificar

        //Recorrer cada caracter
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombreMinusculas.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'á' || c == 'é' ||
                    c == 'í' || c == 'ó' || c == 'ú') {
                contadorVocales++;
            }
        }
        return contadorVocales;
    }
    public static boolean esPalindromo(String nombre) {
        // 1. Eliminar espacios y convertir a minúsculas
        String nombreLimpio = nombre.replaceAll("\\s", "").toLowerCase();

        // 2. Comparar caracteres desde el inicio y el final hacia el centro
        int izquierda = 0; // Puntero al inicio del nombre
        int derecha = nombreLimpio.length() - 1; // Puntero al final del nombre

        while (izquierda < derecha) {
            // 3. Comparar los caracteres en las posiciones izquierda y derecha
            if (nombreLimpio.charAt(izquierda) != nombreLimpio.charAt(derecha)) {
                return false; // No es palíndromo
            }
            // 4. Mover los punteros hacia el centro
            izquierda++;
            derecha--;
        }

        // 5. Si todos los caracteres coinciden, es palíndromo
        return true;
    }
    public static ArrayList<String> encontrarNombresPalindromos(ArrayList<Children> boys) {
        ArrayList<String> nombresPalindromos = new ArrayList<>(); // Lista para almacenar los nombres palíndromos

        // Recorrer la lista de niños
        for (Children child : boys) {
            // Verificar si el nombre es palíndromo
            if (esPalindromo(child.getNombre())) {
                // Si es palíndromo, agregarlo a la lista
                nombresPalindromos.add(child.getNombre());
            }
        }

        return nombresPalindromos; // Devolver la lista de nombres palíndromos
    }

    public static int contarConsonantes(String nombre) {
        int contadorConsonantes = 0;
        String nombreMinusculas = nombre.toLowerCase(); // Convertir a minúsculas para simplificar

        //Recorrer cada caracter
        for (int i = 0; i < nombreMinusculas.length(); i++) {
            char c = nombreMinusculas.charAt(i);
            // Verificar si el carácter es una consonante
            if (c >= 'a' && c <= 'z' && !esVocal(c)) {
                contadorConsonantes++;
            }
        }
        return contadorConsonantes;
    }
    // Método para verificar si un carácter es una vocal
    public static boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static String nombreConMasConsonantes(ArrayList<Children> boys) {
        String nombreConMasConsonantes = ""; // Almacena el nombre con más consonantes
        int maxConsonantes = 0; // Almacena la cantidad máxima de consonantes encontradas

        // Recorrer la lista de niños
        for (Children child : boys) {
            String nombre = child.getNombre();
            int contadorConsonantes = contarConsonantes(nombre);

            // Si el nombre actual tiene más consonantes, actualizar el máximo
            if (contadorConsonantes > maxConsonantes) {
                maxConsonantes = contadorConsonantes;
                nombreConMasConsonantes = nombre;
            }
        }
        return nombreConMasConsonantes;
    }
    public static String nombreNoVocales(String nombre) {
        // Crear un StringBuilder para construir el nuevo nombre sin vocales
        StringBuilder nombreSinVocales = new StringBuilder();

        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (!esVocal(c)) {
                nombreSinVocales.append(c);
            }
        }
        // Devolver el nombre sin vocales
        return nombreSinVocales.toString();
    }
    public static void eliminarVocales(ArrayList<Children> boys) {
        for (Children child : boys) {
            // Obtener el nombre actual
            String nombre = child.getNombre();
            // Eliminar las vocales del nombre
            String nombreSinVocales = nombreNoVocales(nombre);
            // Actualizar el nombre del niño
            child.setNombre(nombreSinVocales);
        }
        System.out.println("Se eliminaron las vocales de todos los nombres");
    }
}