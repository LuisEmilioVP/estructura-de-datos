/*
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 16/05/2025
 */

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase que implementa el algoritmo de ordenamiento por Selección (Selection
 * Sort)
 * Permite al usuario ingresar un conjunto de números y los ordena de manera
 * ascendente
 */
public class MetodoSeleccion {

    // * Método principal que ejecuta el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0; // * Cantidad de elementos a ordenar
        int[] arreglo = null; // * Arreglo para almacenar los elementos

        // * Solicitar al usuario la cantidad de elementos
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Ingrese la cantidad de elementos a ordenar: ");
                n = scanner.nextInt();

                // * Validar que la cantidad sea positiva
                if (n <= 0) {
                    System.out.println("Error: La cantidad debe ser un numero positivo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero entero.");
                scanner.nextLine(); // * Limpiar el buffer
            }
        }

        // * Inicializar el arreglo con la cantidad especificada
        arreglo = new int[n];

        // * Solicitar al usuario los elementos uno por uno
        System.out.println("\nIngrese los " + n + " elementos:");
        for (int i = 0; i < n; i++) {
            boolean elementoValido = false;
            while (!elementoValido) {
                try {
                    System.out.print("Elemento " + (i + 1) + ": ");
                    arreglo[i] = scanner.nextInt();
                    elementoValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un número entero.");
                    scanner.nextLine(); // * Limpiar el buffer
                }
            }
        }

        // * Mostrar el arreglo antes de ordenarlo
        System.out.println("\nArreglo original:");
        imprimirArreglo(arreglo);

        // * Ordenar el arreglo utilizando el método de selección
        ordenamientoPorSeleccion(arreglo);

        // * Mostrar el arreglo ordenado
        System.out.println("\nArreglo ordenado (ascendente):");
        imprimirArreglo(arreglo);

        // * Cerrar el scanner
        scanner.close();
    }

    /**
     * Implementación del algoritmo de ordenamiento por Selección
     * Ordena el arreglo en orden ascendente
     */
    public static void ordenamientoPorSeleccion(int[] arreglo) {
        int n = arreglo.length;

        // * Recorrer el arreglo
        for (int i = 0; i < n - 1; i++) {
            // * Encontrar el elemento mínimo en el arreglo no ordenado
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            /*
             * Intercambiar el elemento mínimo encontrado con el primer elemento no
             * ordenado
             * Solo si el índice mínimo cambió
             */
            if (indiceMinimo != i) {
                int temp = arreglo[indiceMinimo];
                arreglo[indiceMinimo] = arreglo[i];
                arreglo[i] = temp;
            }

            // * Para mostrar el estado del arreglo después de cada iteración (opcional)
            // * System.out.println("Después de la iteración " + (i+1) + ": ");
            // * imprimirArreglo(arreglo);
        }
    }

    // * Método auxiliar para imprimir un arreglo
    public static void imprimirArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}