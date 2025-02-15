/*
 * Practica de tipos de datos
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 15/02/2025
 */

import java.util.Scanner;

public class EjerciciosTiposDatos {
  private static Scanner scanner = new Scanner(System.in);

  // Ejercicio 1 - Enteros
  public static void EjercicioEnteros() {
    System.out.println("\n--- Ejercicio 1: Enteros ---");

    try {
      // Parte a - Dos numeros enteros y mostrar en pantalla
      System.out.println("Ingrese el primer número entero: ");
      int numero1 = scanner.nextInt();

      System.out.println("Ingrese el segundo número entero: ");
      int numero2 = scanner.nextInt();

      System.out.println("Los numeros ingresados son: " + numero1 + " y " +
          numero2);

      // Parte b - Tres números y su producto
      System.out.println("Ingrese el tercer número entero: ");
      int numero3 = scanner.nextInt();

      // Sacar el producto de los números ingresados
      long producto = (long) numero1 * numero2 * numero3;

      System.out.printf("El produicto de los tres números es: %d%n", producto);
    } catch (Exception e) {
      // Si se ingresa un valor no entero, se muestra un mensaje de error
      System.out.println("Error: Debe ingresar un númerro entero valido");
      scanner.nextLine(); // Limpia el buffer de entrada
    }
  }

  // Ejercicio 2 - Flotantes
  public static void EjercicioFlotantes() {
    System.out.println("\n--- Ejercicio 2: Flotantes ---");

    try {
      System.out.println("Ingrese un número decimal (ej: 3.14): ");
      double numero = scanner.nextDouble();

      // Obtener la parte entera del decimal ingresado
      int parteEntera = (int) numero;
      // Obtener la parte decimal del número ingresado uasando la función Math
      double parteDecimal = Math.abs(numero - parteEntera);

      // Mostrar las partes por separado del decimal
      System.out.printf("Parte entera: %d | Parte decimal %.2f%n", parteEntera,
          parteDecimal);
    } catch (Exception e) {
      System.out.println("Error: Debe ingresar un número decimal válido");
      scanner.nextLine(); // limpiar el buffer
    }
  }

  // Ejercicio 3 - Cadenas de caracteres
  public static void EjercicioCadenas() {
    System.out.println("\n--- Ejercicio 3: Cadenas ---");

    System.out.println("Ingrese su primer nombre: ");
    String nombre = scanner.nextLine();

    System.out.println("Ingrese su primer apellido: ");
    String apellido = scanner.nextLine();

    System.out.printf("¡Hola, %s %s! Bienvenido/a al sistema.%n", nombre,
        apellido);
  }

  // Ejercicio 4 - Booleanos
  public static void EjercicioBooleanos() {
    System.out.println("\n--- Ejercicio 4: Booleanos ---");

    try {
      // Parte a) Verificación de edad
      System.out.println("Ingrese su edad: ");

      int edad = scanner.nextInt();
      // Cacturar la edad y validar si es mayor
      boolean esMayor = edad >= 18;

      System.out.printf("¿Es mayor de edad? %b%n", esMayor);

      // Parte b) Número positivo/negativo
      System.out.println("Ingrese un número entero");
      int numero = scanner.nextInt();

      if (numero > 0) {
        System.out.printf("El número %d es positivo%n", numero);
      } else if (numero < 0) {
        System.out.printf("El número %d es negativo%n", numero);
      } else {
        System.out.println("El número es cero");
      }

    } catch (Exception e) {
      System.out.println("Error: Entrada inválida");
      scanner.nextLine(); // Limpia el buffer
    }
  }

  public static void main(String[] args) {
    System.out.println("Programa de práctica de tipos de datos, variables y operaciones");

    EjercicioEnteros(); // Ejercicio 1
    EjercicioFlotantes(); // Ejercicio 2
    EjercicioCadenas(); // Ejercicio 3
    EjercicioBooleanos(); // Ejercicio 4

    scanner.close();
  }
}