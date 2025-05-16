/*
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 15/05/2025
 */

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Programa que implementa la búsqueda secuencial para caracteres y números
 */
public class BusquedaSecuencial {

    private static Scanner scanner = new Scanner(System.in);

    // * Método principal que ejecuta el programa
    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            // * Mostrar el menú principal
            mostrarMenuPrincipal();

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // * Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        // * Búsqueda de caracteres
                        realizarBusquedaCaracteres();
                        break;
                    case 2:
                        // * Búsqueda numérica
                        realizarBusquedaNumerica();
                        break;
                    case 3:
                        // * Salir del programa
                        salir = true;
                        System.out.println("¡Gracias por usar el programa de búsqueda secuencial!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.nextLine(); // * Limpiar el buffer de entrada
            }
        }

        // * Cerrar el scanner al salir
        scanner.close();
    }

    // * Muestra el menú principal del programa
    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Busqueda de caracteres");
        System.out.println("2. Busqueda numérica");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    /**
     * Implementa la funcionalidad de búsqueda de caracteres
     */
    private static void realizarBusquedaCaracteres() {
        System.out.println("\n=== BUSQUEDA DE CARACTERES ===");

        // Pedir la cantidad de elementos
        int cantidad = solicitarCantidadElementos();

        // Crear y llenar el arreglo de strings
        String[] arreglo = new String[cantidad];
        llenarArregloStrings(arreglo);

        // Imprimir el arreglo para referencia
        System.out.println("\nElementos ingresados:");
        imprimirArregloStrings(arreglo);

        boolean continuarBusqueda = true;
        while (continuarBusqueda) {
            // Solicitar el elemento a buscar
            System.out.print("\nIngrese el caracter o palabra a buscar: ");
            String elementoBuscar = scanner.nextLine();

            // Realizar la búsqueda secuencial
            int posicion = busquedaSecuencialString(arreglo, elementoBuscar);

            // Mostrar el resultado
            if (posicion != -1) {
                System.out.println("Elemento encontrado en la posicion " + (posicion + 1) + ".");
            } else {
                System.out.println("El elemento \"" + elementoBuscar + "\" no se encontro en el arreglo.");
            }

            // * Preguntar si desea continuar buscando
            continuarBusqueda = preguntarContinuarBusqueda();
        }
    }

    // * Implementa la funcionalidad de búsqueda numérica
    private static void realizarBusquedaNumerica() {
        System.out.println("\n=== BÚSQUEDA NUMÉRICA ===");

        // * Pedir la cantidad de elementos
        int cantidad = solicitarCantidadElementos();

        // * Crear y llenar el arreglo de números
        int[] arreglo = new int[cantidad];
        llenarArregloNumeros(arreglo);

        // * Imprimir el arreglo para referencia
        System.out.println("\nElementos ingresados:");
        imprimirArregloNumeros(arreglo);

        boolean continuarBusqueda = true;
        while (continuarBusqueda) {
            // * Solicitar el elemento a buscar
            int elementoBuscar = solicitarNumeroBuscar();

            // * Realizar la búsqueda secuencial
            int posicion = busquedaSecuencialNumero(arreglo, elementoBuscar);

            // * Mostrar el resultado
            if (posicion != -1) {
                System.out.println("Elemento encontrado en la posición " + (posicion + 1) + ".");
            } else {
                System.out.println("El elemento " + elementoBuscar + " no se encontró en el arreglo.");
            }

            // * Preguntar si desea continuar buscando
            continuarBusqueda = preguntarContinuarBusqueda();
        }
    }

    // * Solicita al usuario la cantidad de elementos a ingresar
    private static int solicitarCantidadElementos() {
        int cantidad = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese la cantidad de elementos: ");
                cantidad = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                if (cantidad <= 0) {
                    System.out.println("Error: La cantidad debe ser un numero positivo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero entero.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }

        return cantidad;
    }

    // * Llena un arreglo de strings con entradas del usuario
    private static void llenarArregloStrings(String[] arreglo) {
        System.out.println("\nIngrese los elementos uno por uno:");

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arreglo[i] = scanner.nextLine();
        }
    }

    // * Llena un arreglo de números con entradas del usuario
    private static void llenarArregloNumeros(int[] arreglo) {
        System.out.println("\nIngrese los elementos uno por uno:");

        for (int i = 0; i < arreglo.length; i++) {
            boolean entradaValida = false;

            while (!entradaValida) {
                try {
                    System.out.print("Elemento " + (i + 1) + ": ");
                    arreglo[i] = scanner.nextInt();
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un numero entero.");
                    scanner.nextLine(); // * Limpiar el buffer de entrada
                }
            }
        }

        scanner.nextLine(); // * Consumir el salto de línea después del último número
    }

    // * Solicita al usuario un número para buscar
    private static int solicitarNumeroBuscar() {
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("\nIngrese el número a buscar: ");
                numero = scanner.nextInt();
                scanner.nextLine(); // * Consumir el salto de línea
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }

        return numero;
    }

    // * Pregunta al usuario si desea continuar buscando
    private static boolean preguntarContinuarBusqueda() {
        System.out.println("\n¿Que desea hacer?");
        System.out.println("1. Buscar otro elemento en el mismo arreglo");
        System.out.println("2. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");

        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // * Consumir el salto de línea

            return opcion == 1;
        } catch (InputMismatchException e) {
            System.out.println("Entrada no valida. Volviendo al menu principal.");
            scanner.nextLine(); // * Limpiar el buffer de entrada
            return false;
        }
    }

    /**
     * Implementa el algoritmo de búsqueda secuencial para strings
     * 
     * @param arreglo  El arreglo donde buscar
     * @param elemento El elemento a buscar
     */
    private static int busquedaSecuencialString(String[] arreglo, String elemento) {
        for (int i = 0; i < arreglo.length; i++) {
            /*
             * Comparamos ignorando mayúsculas y minúsculas para una mejor experiencia de
             * usuario
             */
            if (arreglo[i].equalsIgnoreCase(elemento)) {
                return i; // * Elemento encontrado, devolvemos su posición
            }
        }
        return -1; // * Elemento no encontrado
    }

    /**
     * Implementa el algoritmo de búsqueda secuencial para números
     * 
     * @param arreglo  El arreglo donde buscar
     * @param elemento El elemento a buscar
     * @return La posición del elemento si se encuentra, -1 si no se encuentra
     */
    private static int busquedaSecuencialNumero(int[] arreglo, int elemento) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == elemento) {
                return i; // * Elemento encontrado, devolvemos su posición
            }
        }
        return -1; // * Elemento no encontrado
    }

    // * Imprime los elementos de un arreglo de strings
    private static void imprimirArregloStrings(String[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // * Imprime los elementos de un arreglo de números
    private static void imprimirArregloNumeros(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
