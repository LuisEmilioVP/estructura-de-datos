/*
 * Historial de Navegación
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 09/03/2025
 */
package Navegacion;

import java.util.Scanner;

/**
 * Clase principal que simula un navegador web con historial de navegación
 * utilizando una estructura de datos Pila.
 */
public class HistorialNavegacion {
  public static void main(String[] args) {
    // Inicializamos el scanner para entrada de usuario
    Scanner scanner = new Scanner(System.in);

    // Creamos una pila para almacenar el historial de navegación
    PilaHistorial historial = new PilaHistorial();

    // Variable para almacenar la opción del usuario
    int opcion;

    // URL de la página actual
    String paginaActual = "";

    System.out.println("===== SIMULADOR DE NAVEGADOR WEB =====");

    do {
      System.out.println("\nMenú de navegación:");
      System.out.println("1. Visitar una nueva página web");
      System.out.println("2. Retroceder a la página anterior");
      System.out.println("3. Mostrar historial de navegación");
      System.out.println("4. Mostrar página actual");
      System.out.println("5. Salir del navegador");
      System.out.print("Seleccione una opción: ");

      opcion = scanner.nextInt();
      scanner.nextLine(); // Consumir el salto de línea

      switch (opcion) {
        case 1:
          // Si ya hay una página actual, la guardamos en el historial
          if (!paginaActual.isEmpty()) {
            historial.push(paginaActual);
          }

          // Solicitamos la nueva URL
          System.out.print("Ingrese la URL de la página a visitar: ");
          paginaActual = scanner.nextLine();

          System.out.println("\n¡Visitando página: " + paginaActual + "!");
          System.out.println("La página anterior se ha guardado en el historial.");
          break;

        case 2:
          // Verificamos si hay páginas en el historial para retroceder
          if (historial.isEmpty()) {
            System.out.println("\nNo hay páginas anteriores en el historial.");
            if (paginaActual.isEmpty()) {
              System.out.println("No hay ninguna página abierta actualmente.");
            } else {
              System.out.println("Página actual: " + paginaActual);
            }
          } else {
            // Obtenemos la página anterior del historial
            String paginaAnterior = historial.pop();
            System.out.println("\n¡Retrocediendo a la página anterior: " + paginaAnterior + "!");

            // Actualizamos la página actual
            paginaActual = paginaAnterior;
          }
          break;

        case 3:
          // Mostramos el historial de navegación
          System.out.println("\n===== HISTORIAL DE NAVEGACIÓN =====");
          if (historial.isEmpty() && paginaActual.isEmpty()) {
            System.out.println("El historial está vacío. No has visitado ninguna página.");
          } else {
            historial.mostrarHistorial();
            if (!paginaActual.isEmpty()) {
              System.out.println("\nPágina actual: " + paginaActual);
            }
          }
          break;

        case 4:
          // Mostramos la página actual
          if (paginaActual.isEmpty()) {
            System.out.println("\nNo hay ninguna página abierta actualmente.");
          } else {
            System.out.println("\nPágina actual: " + paginaActual);
          }
          break;

        case 5:
          System.out.println("\n¡Gracias por usar el simulador de navegador web!");
          break;

        default:
          System.out.println("\nOpción no válida. Por favor, intente nuevamente.");
      }

    } while (opcion != 5);

    scanner.close();
  }
}

/**
 * Clase que representa un nodo en la pila de historial.
 * Cada nodo contiene una URL y una referencia al nodo anterior.
 */
class NodoHistorial {
  private String url;
  private NodoHistorial anterior;

  /**
   * Constructor para crear un nuevo nodo con una URL específica.
   */
  public NodoHistorial(String url) {
    this.url = url;
    this.anterior = null;
  }

  /**
   * Método para obtener la URL del nodo.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Método para obtener el nodo anterior en la pila.
   */
  public NodoHistorial getAnterior() {
    return anterior;
  }

  /**
   * Método para establecer el nodo anterior en la pila.
   */
  public void setAnterior(NodoHistorial anterior) {
    this.anterior = anterior;
  }
}

/**
 * Clase que implementa una estructura de datos tipo Pila
 * para almacenar el historial de navegación.
 */
class PilaHistorial {
  private NodoHistorial cima;
  private int tamaño;

  /**
   * Constructor para crear una pila de historial vacía.
   */
  public PilaHistorial() {
    this.cima = null;
    this.tamaño = 0;
  }

  /**
   * Método para agregar una URL a la pila (apilar).
   */
  public void push(String url) {
    NodoHistorial nuevoNodo = new NodoHistorial(url);

    if (isEmpty()) {
      cima = nuevoNodo;
    } else {
      nuevoNodo.setAnterior(cima);
      cima = nuevoNodo;
    }

    tamaño++;
  }

  /**
   * Método para eliminar y devolver la URL en la cima de la pila (desapilar).
   */
  public String pop() {
    if (isEmpty()) {
      return null;
    }

    String url = cima.getUrl();
    cima = cima.getAnterior();
    tamaño--;

    return url;
  }

  /**
   * Método para verificar si la pila está vacía.
   */
  public boolean isEmpty() {
    return cima == null;
  }

  /**
   * Método para mostrar todo el historial de navegación.
   */
  public void mostrarHistorial() {
    if (isEmpty()) {
      System.out.println("El historial está vacío.");
      return;
    }

    System.out.println("Páginas visitadas (de la más reciente a la más antigua):");

    NodoHistorial actual = cima;
    int contador = 1;

    while (actual != null) {
      System.out.println(contador + ". " + actual.getUrl());
      actual = actual.getAnterior();
      contador++;
    }
  }

  /**
   * Método para obtener el tamaño de la pila.
   */
  public int getTamaño() {
    return tamaño;
  }
}
