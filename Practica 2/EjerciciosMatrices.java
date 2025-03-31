/*
 * Ejercicio Con Matrices
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 22/02/2025
 */

import java.util.Arrays;

public class EjerciciosMatrices {

  // Ejercicio 1: Producto Escalar de Vectores
  public static void Ejercicio1() {
    System.out.println("\n--- Ejercicio 1: Producto Escalar de Vectores ---");

    // Declaración del los Vectores
    int[] vector1 = { 1, 2, 3, 4 };
    int[] vector2 = { 5, 6, 7, 8 };

    // Calcular el producto escalar de los Vectores
    int productoEscalar = 0;

    for (int i = 0; i < vector1.length; i++) {
      productoEscalar += vector1[i] * vector2[i]; // Asignacion y multiplicacion de los vectores
    }

    // Mostrar los resultados
    System.out.println("Vector 1: " + Arrays.toString(vector1));
    System.out.println("Vector 2: " + Arrays.toString(vector2));
    System.out.println("\nProducto Escalar = (" + vector1[0] + "x" + vector2[0] +
        ") + ("
        + vector1[1] + "x" + vector2[1] + ") + ("
        + vector1[2] + "x" + vector2[2] + ") + ("
        + vector1[3] + "x" + vector2[3] + ")");
    System.out.println("Producto escalar es: " + productoEscalar);
  }

  // Ejercicio 2: Matriz de Calificaciones de Alumnos
  public static void Ejercicio2() {
    System.out.println("\n--- Ejercicio 2: Matriz de Calificaciones ---");

    // Declaración de una Matriz 3 x 3
    int[][] calificaciones = {
        { 75, 83, 60 },
        { 92, 87, 77 },
        { 78, 84, 81 }
    };

    // Mostrar las calificaciones almacenadas en la matriz
    System.out.println("Matriz de Calificaciones:");

    for (int i = 0; i < calificaciones.length; i++) {
      System.out.println("Alumno " + (i + 1) + ": " +
          Arrays.toString(calificaciones[i]));
    }

    // Calcular el promedio de las calificaciones
    System.out.println("\nPromedios:");

    for (int i = 0; i < calificaciones.length; i++) {
      double promedio = 0;

      for (int nota : calificaciones[i]) {
        promedio += nota;
      }

      promedio /= calificaciones[i].length;

      // Mostrar cada alumno con su respectivo promedio
      System.out.printf("Alumno %d Promedio: %.2f%n", (i + 1), promedio);
    }
  }

  // Ejercicio 3: Matriz utilizando Nombres de Frutas
  public static void Ejercicio3() {
    System.out.println("\n--- Ejercicio 3: Matriz de Frutas ---");

    String[][] frutas = {
        { "Manzana", "Guineo", "Pera" },
        { "Naranja", "Uva", "Mango" },
        { "Limón", "Lechoza", "Sandia" }
    };

    System.out.println("Frutas:");

    /*
     * Declaración de dos ciclos una para iterar por las filas de la matriz y el
     * otro para que muestre las furtas deacuerdoa su posicion de las columnas en la
     * matriz.
     */
    for (String[] fila : frutas) {
      for (String fruta : fila) {
        System.out.println("-" + fruta);
      }
    }
  }

  // Ejercicio 4: Operaciones Matriciales
  public static void Ejercicio4() {
    System.out.println("\n--- Ejercicio 4: Operaciones Matriciales ---");

    int[][] matriz1 = { { 3, 5, 9, 4 }, { 10, 1, 7, 14 } };
    int[][] matriz2 = { { 1, 2, 6, 12 }, { 5, 11, 7, 8 } };

    // Mostrar matrices originales
    System.out.println("Matriz 1:");
    mostrarMatriz(matriz1);

    System.out.println("Matriz 2:");
    mostrarMatriz(matriz2);

    // Realizar operaciones
    System.out.println("\nResultados:");

    // Suma
    System.out.println("Suma:");
    int[][] suma = new int[matriz1.length][matriz1[0].length];
    for (int i = 0; i < matriz1.length; i++) {
      for (int j = 0; j < matriz1[0].length; j++) {
        suma[i][j] = matriz1[i][j] + matriz2[i][j];
      }
    }

    mostrarMatriz(suma);

    // Resta
    System.out.println("\nResta:");
    int[][] resta = new int[matriz1.length][matriz1[0].length];
    for (int i = 0; i < matriz1.length; i++) {
      for (int j = 0; j < matriz1[0].length; j++) {
        resta[i][j] = matriz1[i][j] - matriz2[i][j];
      }
    }

    mostrarMatriz(resta);

    // Multiplicación elemento a elemento
    System.out.println("\nMultiplicación:");
    int[][] multiplicacion = new int[matriz1.length][matriz1[0].length];
    for (int i = 0; i < matriz1.length; i++) {
      for (int j = 0; j < matriz1[0].length; j++) {
        multiplicacion[i][j] = matriz1[i][j] * matriz2[i][j];
      }
    }

    mostrarMatriz(multiplicacion);
  }

  // Método auxiliar para mostrar matrices
  private static void mostrarMatriz(int[][] matriz) {
    for (int[] fila : matriz) {
      System.out.println(Arrays.toString(fila));
    }
  }

  // Ejercicio 5: Matriz de Puntos Flotantes y Promedio de Notas
  public static void Ejercicio5() {
    System.out.println("\n--- Ejercicio 5: Matriz de Calificaciones Flotantes ---");

    double[][] calificaciones = {
        { 8.5, 7.0, 9.2 },
        { 6.8, 8.0, 7.5 }
    };

    // Mostrar las filas de las matrices por alumno
    System.out.println("Matriz de Calificaciones:");

    for (int i = 0; i < calificaciones.length; i++) {
      System.out.println("Alumno " + (i + 1) + ": " + Arrays.toString(calificaciones[i]));
    }

    System.out.println("\nPromedios:");
    for (int i = 0; i < calificaciones.length; i++) { // Recorrer la matriz hasta su mayor tamaño
      double promedio = 0;
      for (double nota : calificaciones[i]) { // Recorrer y asignar a promedio las notas
        promedio += nota;
      }

      // Sacar el promedio de las calificaciones dentro de la matriz
      promedio /= calificaciones[i].length;

      System.out.printf("Alumno %d Promedio: %.2f%n", (i + 1), promedio);
    }
  }

  public static void main(String[] args) {
    System.out.println("\n--- Ejercicio con Vectores ---");
    // Funciones con los EjerciciosMatrices
    Ejercicio1();
    Ejercicio2();
    Ejercicio3();
    Ejercicio4();
    Ejercicio5();
  }
}