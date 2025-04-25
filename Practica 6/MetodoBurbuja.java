
/**
 * Clase que implementa el algoritmo de ordenamiento Burbuja (Bubble Sort)
 * Permite al usuario ingresar un conjunto de números y los ordena de manera
 * ascendente
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 24/04/2025
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class MetodoBurbuja {
  /**
   * Método principal que ejecuta el programa
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = 0;
    int[] arreglo = null;

    // Solicitar al usuario la cantidad de elementos
    boolean entradaValida = false;
    while (!entradaValida) {
      try {
        System.out.print("Ingrese la cantidad de elementos a ordenar: ");
        n = scanner.nextInt();

        // Validar que la cantidad sea positiva
        if (n <= 0) {
          System.out.println("Error: La cantidad debe ser un numero positivo.");
        } else {
          entradaValida = true;
        }
      } catch (InputMismatchException e) {
        System.out.println("Error: Debe ingresar un numero entero.");
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
          System.out.println("Error: Debe ingresar un numero entero.");
          scanner.nextLine(); // Limpiar el buffer de entrada
        }
      }
    }

    // Mostrar el arreglo antes de ordenarlo
    System.out.println("\nArreglo original:");
    imprimirArreglo(arreglo);

    // Ordenar el arreglo utilizando el método de burbuja
    ordenamientoBurbuja(arreglo);

    // Mostrar el arreglo ordenado
    System.out.println("\nArreglo ordenado (ascendente):");
    imprimirArreglo(arreglo);

    // Cerrar el scanner
    scanner.close();
  }

  /**
   * Implementación del algoritmo de ordenamiento Burbuja
   * Ordena el arreglo en orden ascendente
   * Arreglo a ordenar
   */

  public static void ordenamientoBurbuja(int[] arreglo) {
    int n = arreglo.length;

    // Se realizan n-1 pasadas por el arreglo
    for (int i = 0; i < n - 1; i++) {
      // Variable para optimizar el algoritmo
      boolean intercambioRealizado = false;

      // En cada pasada, comparamos elementos adyacentes
      // Los elementos más grandes "burbujean" hacia el final
      for (int j = 0; j < n - i - 1; j++) {
        // Si el elemento actual es mayor que el siguiente, intercambiarlos
        if (arreglo[j] > arreglo[j + 1]) {
          // Intercambio de elementos
          int temp = arreglo[j];
          arreglo[j] = arreglo[j + 1];
          arreglo[j + 1] = temp;

          intercambioRealizado = true;
        }
      }

      // Si no se realizó ningún intercambio en esta pasada,
      // el arreglo ya está ordenado, por lo que podemos salir
      if (!intercambioRealizado) {
        break;
      }
    }
  }

  /**
   * Método auxiliar para imprimir un arreglo
   * Arreglo a imprimir
   */
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
