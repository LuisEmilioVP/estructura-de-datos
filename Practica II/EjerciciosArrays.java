/*
 * Ejercicios con Arrays
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 21/02/2025
 */

import java.util.Scanner;
import java.util.Arrays;

public class EjerciciosArrays {
  private static Scanner scanner = new Scanner(System.in);

  // Ejercicio 1: Declaración y llenado de un arreglo de enteros
  /*
   * public static void Ejercicio1() {
   * System.out.println("\n--- Ejercicio 1: Declaración y llenado de array ---");
   * 
   * // Declaración del arreglo
   * int[] numeros = new int[5];
   * 
   * // Llenado del arreglo
   * for (int i = 0; i < numeros.length; i++) {
   * System.out.printf("Ingrese el valor para la posición %d: ", i);
   * numeros[i] = scanner.nextInt();
   * }
   * 
   * /*
   * Mostrar el arreglo resultante - pasando el array a una cadena para poder
   * imprimir
   * System.out.println("El arreglo resultante: " + Arrays.toString(numeros));
   * }
   */

  // Ejercicio 2: Recorrido de un arreglo de cadenas
  /*
   * public static void Ejercicio2() {
   * System.out.println("\n--- Ejercicio 2: Array de cadenas ---");
   * // 🍎 - 🍇 - 🍊 - 🍋 - 🍒 - 🍉
   * String[] frutas = { "Manzana", "Uva", "Naranja", "Limón", "Cereza", "Sandía"
   * };
   * 
   * // Mostrar el arreglo de furtas con sus valores originales, si organizar
   * System.out.println("Frutas originales:");
   * for (String freuta : frutas) {
   * System.out.println(freuta);
   * }
   * 
   * // Mostrar el arreglo de furtas con los valores ordenados
   * Arrays.sort(frutas); // Función para ordenar elementos de un array
   * System.out.println("\nFrutas organizadas alfabéticamente:");
   * for (String fruta : frutas) {
   * System.out.println(fruta);
   * }
   * }
   */

  // Ejercicio 3: Reemplazo de valores en un arreglo de enteros
  /*
   * public static void Ejercicio3() {
   * System.out.println("\n--- Ejercicio 3: Reemplazo de valores ---");
   * int[] numeros = { 10, 20, 30, 40, 50 };
   * 
   * System.out.println("Arreglo original: " + Arrays.toString(numeros));
   * 
   * try {
   * System.out.print("Ingrese el índice a modificar (0-4): ");
   * int indice = scanner.nextInt();
   * 
   * /*
   * Validar si el usuario esta agredado un número que este dentro del rango del
   * arreglo
   * 
   * if (indice >= 0 && indice < numeros.length) { // Si es si que se pueda
   * agregar
   * System.out.print("Ingrese el nuevo valor: ");
   * int nuevoValor = scanner.nextInt();
   * numeros[indice] = nuevoValor;
   * System.out.println("Arreglo actualizado: " + Arrays.toString(numeros));
   * } else { // Si es no que le indique el mensaje
   * System.out.println("Índice fuera de rango");
   * }
   * } catch (Exception e) {
   * System.out.println("Error: Entrada inválida");
   * scanner.nextLine(); // Limpiar buffer
   * }
   * }
   */

  // Ejercicio 4: Operaciones matemáticas con arreglos
  /*
   * public static void Ejercicio4() {
   * System.out.println("\n--- Ejercicio 4: Operaciones matemáticas ---");
   * int[] array1 = { 1, 2, 3, 4, 5 };
   * int[] array2 = { 4, 5, 6, 7, 8 };
   * /*
   * Asignar el tamaño del arreglo array1 a los nuevos para realizar las
   * operaciones
   * int[] suma = new int[array1.length];
   * int[] resta = new int[array1.length];
   * int[] multiplicacion = new int[array1.length];
   * int[] divicion = new int[array1.length];
   * 
   * // Realizar operaciones
   * for (int i = 0; i < array1.length; i++) {
   * suma[i] = array1[i] + array2[i];
   * resta[i] = array1[i] - array2[i];
   * multiplicacion[i] = array1[i] * array2[i];
   * divicion[i] = array1[i] / array2[i];
   * }
   * 
   * // Mostrar resultados
   * System.out.println("Arreglo 1: " + Arrays.toString(array1));
   * System.out.println("Arreglo 2: " + Arrays.toString(array2));
   * System.out.println("\nResultados:");
   * System.out.println("Suma: " + Arrays.toString(suma));
   * System.out.println("Resta: " + Arrays.toString(resta));
   * System.out.println("Multiplicación: " + Arrays.toString(multiplicacion));
   * System.out.println("Divición: " + Arrays.toString(divicion));
   * }
   */

  // Ejercicio 5: Arreglo de punto flotante y cálculo de promedio
  public static void Ejercicio5() {
    System.out.println("\n--- Ejercicio 5: Promedio de calificaciones ---");
    double[] calificaciones = { 8.5, 7.0, 9.2, 6.7, 8.5 };

    // Calcular promedio
    double suma = 0;
    for (double calificacion : calificaciones) {
      suma += calificacion; // Asignando elementos y sumando
    }

    double promedio = suma / calificaciones.length; // Dividir el la suma con el número de elementos del arreglo

    // Mostrar resultados
    System.out.println("Calificaciones: " + Arrays.toString(calificaciones));
    System.out.printf("Promedio de las calificaciones: %.2f%n", promedio);
  }

  public static void main(String[] args) {

    // Funciones con los diferentes ejercicios propuestos:
    // Ejercicio1();
    // Ejercicio2();
    // Ejercicio3();
    // Ejercicio4();
    Ejercicio5();
  }
}
