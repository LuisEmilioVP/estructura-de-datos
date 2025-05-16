/*
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 16/05/2025
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Programa que implementa la búsqueda binaria para números
 * con un menú interactivo
 */
public class BusquedaBinaria {

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
                        // * Búsqueda numérica
                        realizarBusquedaNumerica();
                        break;
                    case 2:
                        // * Salir del programa
                        salir = true;
                        System.out.println("¡Gracias por usar el programa de busqueda binaria!");
                        break;
                    default:
                        System.out.println("Opcion no valida. Por favor, seleccione una opcion del menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero entero.");
                scanner.nextLine(); // * Limpiar el buffer
            }
        }

        // * Cerrar el scanner al salir
        scanner.close();
    }

    // * Muestra el menú principal del programa
    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Busqueda numérica");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    /**
     * Implementa la funcionalidad de búsqueda numérica con búsqueda binaria
     */
    private static void realizarBusquedaNumerica() {
        System.out.println("\n=== BUSQUEDA NUMERICA BINARIA ===");

        // * Pedir la cantidad de elementos
        int cantidad = solicitarCantidadElementos();

        // * Crear y llenar el arreglo de números
        int[] arreglo = new int[cantidad];
        llenarArregloNumeros(arreglo);

        // * Imprimir el arreglo original para referencia
        System.out.println("\nElementos ingresados (arreglo original):");
        imprimirArreglo(arreglo);

        // * Ordenar el arreglo (requisito para la búsqueda binaria)
        Arrays.sort(arreglo);

        // * Imprimir el arreglo ordenado
        System.out.println("\nArreglo ordenado (necesario para busqueda binaria):");
        imprimirArreglo(arreglo);

        boolean continuarBusqueda = true;
        while (continuarBusqueda) {
            // * Solicitar el elemento a buscar
            int elementoBuscar = solicitarNumeroBuscar();

            // * Realizar la búsqueda binaria
            int posicion = busquedaBinaria(arreglo, elementoBuscar);

            // * Mostrar el resultado
            if (posicion != -1) {
                /*
                 * Se suma 1 a la posición para hacerla más intuitiva para el usuario (comienza
                 * en 1 en lugar de 0)
                 */
                System.out.println("Elemento encontrado en la posicion " + (posicion + 1) + ".");
            } else {
                System.out.println("El elemento " + elementoBuscar + " no se encontro en el arreglo.");
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
                scanner.nextLine(); // * Consumir el salto de línea

                if (cantidad <= 0) {
                    System.out.println("Error: La cantidad debe ser un numero positivo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero entero.");
                scanner.nextLine(); // * Limpiar el buffer
            }
        }

        return cantidad;
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
                    scanner.nextLine(); // Limpiar el buffer de entrada
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
                System.out.print("\nIngrese el numero a buscar: ");
                numero = scanner.nextInt();
                scanner.nextLine(); // * Consumir el salto de línea
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero entero.");
                scanner.nextLine(); // * Limpiar el buffer
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
            scanner.nextLine(); // * Limpiar el buffer
            return false;
        }
    }

    /**
     * Implementa el algoritmo de búsqueda binaria
     * Requiere que el arreglo esté ordenado
     * 
     * @param arreglo  El arreglo ordenado donde buscar
     * @param elemento El elemento a buscar
     *                 La posición del elemento si se encuentra, -1 si no se
     *                 encuentra
     */
    private static int busquedaBinaria(int[] arreglo, int elemento) {
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {
            // * Calcular el punto medio del rango actual
            int medio = inicio + (fin - inicio) / 2;

            // * Si el elemento está en el medio, lo encontramos
            if (arreglo[medio] == elemento) {
                return medio;
            }

            // * Si el elemento es mayor que el punto medio, buscar en la mitad derecha
            if (arreglo[medio] < elemento) {
                inicio = medio + 1;
            }
            // * Si el elemento es menor que el punto medio, buscar en la mitad izquierda
            else {
                fin = medio - 1;
            }
        }

        // * Si llegamos aquí, el elemento no está en el arreglo
        return -1;
    }

    // * Imprime los elementos de un arreglo
    private static void imprimirArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}