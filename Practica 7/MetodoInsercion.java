
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase que implementa el algoritmo de ordenamiento por Inserción (Insertion
 * Sort)
 * Permite al usuario ingresar un conjunto de números y los ordena de manera
 * ascendente
 */

public class MetodoInsercion {

    // * Método principal que ejecuta el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0; // Cantidad de elementos a ordenar
        int[] arreglo = null; // Arreglo para almacenar los elementos

        // Solicitar al usuario la cantidad de elementos
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Ingrese la cantidad de elementos a ordenar: ");
                n = scanner.nextInt();

                // Validar que la cantidad sea positiva
                if (n <= 0) {
                    System.out.println("Error: La cantidad debe ser un número positivo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        }

        // Inicializar el arreglo con la cantidad especificada
        arreglo = new int[n];

        // Solicitar al usuario los elementos uno por uno
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
                    scanner.nextLine(); // Limpiar el buffer de entrada
                }
            }
        }

        // Mostrar el arreglo antes de ordenarlo
        System.out.println("\nArreglo original:");
        imprimirArreglo(arreglo);

        // Ordenar el arreglo utilizando el método de inserción
        ordenamientoPorInsercion(arreglo);

        // Mostrar el arreglo ordenado
        System.out.println("\nArreglo ordenado (ascendente):");
        imprimirArreglo(arreglo);

        // Cerrar el scanner
        scanner.close();
    }

    /**
     * Implementación del algoritmo de ordenamiento por Inserción
     * Ordena el arreglo en orden ascendente
     */
    public static void ordenamientoPorInsercion(int[] arreglo) {
        int n = arreglo.length;

        // Empezamos desde el segundo elemento (índice 1)
        // Asumimos que el primer elemento ya está "ordenado"
        for (int i = 1; i < n; i++) {
            // Guardamos el valor actual que vamos a insertar en la posición correcta
            int valorActual = arreglo[i];
            int j = i - 1;

            /*
             * Movemos los elementos del arreglo[0...i-1] que son mayores que el valor
             * actual a una posición adelante de su posición actual
             */
            while (j >= 0 && arreglo[j] > valorActual) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }

            // Colocamos el valor actual en su posición correcta en la parte ordenada
            arreglo[j + 1] = valorActual;

            // Para mostrar el estado del arreglo después de cada inserción (opcional)
            // System.out.println("Después de insertar " + valorActual + ": ");
            // imprimirArreglo(arreglo);
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
