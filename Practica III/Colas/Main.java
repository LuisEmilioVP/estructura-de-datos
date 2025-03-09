/*
 * Uso de Colas
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 09/03/2025
 */

package Colas;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Cola cola = new Cola();
    Scanner scanner = new Scanner(System.in);
    int opcion;

    do {
      System.out.println("\nMenú Principal");
      System.out.println("Seleccione una Opción:");
      System.out.println("1 - Agregar un elemento a la Cola");
      System.out.println("2 - Eliminar elemento de la Cola");
      System.out.println("3 - Mostrar elementos en la Cola");
      System.out.println("4 - Salir");
      System.out.print("Opción: ");

      opcion = scanner.nextInt();

      switch (opcion) {
        case 1:
          agregarElementos(cola, scanner);
          break;
        case 2:
          eliminarElemento(cola);
          break;
        case 3:
          mostrarElementos(cola);
          break;
        case 4:
          System.out.println("¡Hasta luego!");
          break;
        default:
          System.out.println("Opción no válida. Intente de nuevo.");
      }
    } while (opcion != 4);

    scanner.close();
  }

  private static void agregarElementos(Cola cola, Scanner scanner) {
    String continuar;
    do {
      System.out.print("Digite el elemento que desea agregar: ");
      int elemento = scanner.nextInt();
      cola.push(elemento);

      scanner.nextLine(); // Consumir el salto de línea
      System.out.print("Desea agregar otro elemento a la Cola s/n? ");
      continuar = scanner.nextLine();
    } while (continuar.equalsIgnoreCase("s"));
  }

  private static void eliminarElemento(Cola cola) {
    if (cola.isEmpty()) {
      System.out.println("La cola está vacía. No hay elementos para eliminar.");
    } else {
      int elementoEliminado = cola.pop();
      System.out.println("¡Elimino el elemento (" + elementoEliminado + ") de la cola!");
    }
  }

  private static void mostrarElementos(Cola cola) {
    if (cola.isEmpty()) {
      System.out.println("La cola está vacía. No hay elementos para mostrar.");
    } else {
      cola.view();
    }
  }
}

class Cola {
  private Nodo frente;
  private Nodo final_;

  public Cola() {
    this.frente = null;
    this.final_ = null;
  }

  // Método para agregar un elemento a la cola
  public void push(int elemento) {
    Nodo nuevoNodo = new Nodo(elemento);

    if (isEmpty()) {
      frente = nuevoNodo;
      final_ = nuevoNodo;
    } else {
      final_.setSiguiente(nuevoNodo);
      final_ = nuevoNodo;
    }
  }

  // Método para eliminar un elemento de la cola
  public int pop() {
    if (isEmpty()) {
      return -1; // Indicar que la cola está vacía
    }

    int elemento = frente.getDato();
    frente = frente.getSiguiente();

    if (frente == null) {
      final_ = null;
    }

    return elemento;
  }

  // Método para mostrar los elementos de la cola
  public void view() {
    if (isEmpty()) {
      System.out.println("La cola está vacía");
      return;
    }

    Nodo actual = frente;
    StringBuilder elementos = new StringBuilder();

    while (actual != null) {
      elementos.append(actual.getDato());

      if (actual.getSiguiente() != null) {
        elementos.append(", ");
      }

      actual = actual.getSiguiente();
    }

    System.out.println(elementos.toString());
  }

  // Método para verificar si la cola está vacía
  public boolean isEmpty() {
    return frente == null;
  }
}

// Nodos enlazados para mantener la estructura de la cola
class Nodo {
  private int dato;
  private Nodo siguiente;

  public Nodo(int dato) {
    this.dato = dato;
    this.siguiente = null;
  }

  // Se tiene un puntero al frente de la cola
  public int getDato() {
    return dato;
  }

  // Se tiene un puntero al final de la cola
  public Nodo getSiguiente() {
    return siguiente;
  }

  // agregan al final al final los nuevos elementos de la cola
  public void setSiguiente(Nodo siguiente) {
    this.siguiente = siguiente;
  }
}