/*
 * Uso de Colas
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 09/03/2025
 */
package Pilas;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Pila pila = new Pila();
    Scanner scanner = new Scanner(System.in);
    int opcion;

    do {
      System.out.println("\nMenú Principal");
      System.out.println("Seleccione una Opción:");
      System.out.println("1 - Agregar un elemento a la Pila");
      System.out.println("2 - Eliminar elemento de la Pila");
      System.out.println("3 - Mostrar elementos en la Pila");
      System.out.println("4 - Salir");
      System.out.print("Opción: ");

      opcion = scanner.nextInt();

      switch (opcion) {
        case 1:
          agregarElementos(pila, scanner);
          break;
        case 2:
          eliminarElemento(pila);
          break;
        case 3:
          mostrarElementos(pila);
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

  private static void agregarElementos(Pila pila, Scanner scanner) {
    String continuar;
    do {
      System.out.print("Digite el elemento que desea agregar: ");
      int elemento = scanner.nextInt();
      pila.push(elemento);

      scanner.nextLine(); // Consumir el salto de línea
      System.out.print("Desea agregar otro elemento a la Pila s/n? ");
      continuar = scanner.nextLine();
    } while (continuar.equalsIgnoreCase("s"));
  }

  private static void eliminarElemento(Pila pila) {
    if (pila.isEmpty()) {
      System.out.println("La pila está vacía. No hay elementos para eliminar.");
    } else {
      int elementoEliminado = pila.pop();
      System.out.println("¡Elimino el elemento (" + elementoEliminado + ") de la Pila!");
    }
  }

  private static void mostrarElementos(Pila pila) {
    if (pila.isEmpty()) {
      System.out.println("La pila está vacía. No hay elementos para mostrar.");
    } else {
      pila.view();
    }
  }
}

class Pila {
  private Nodo cima;

  public Pila() {
    this.cima = null;
  }

  // Método para agregar un elemento a la pila
  public void push(int elemento) {
    Nodo nuevoNodo = new Nodo(elemento);

    if (isEmpty()) {
      cima = nuevoNodo;
    } else {
      nuevoNodo.setSiguiente(cima);
      cima = nuevoNodo;
    }
  }

  // Método para eliminar un elemento de la pila
  public int pop() {
    if (isEmpty()) {
      return -1; // Indicar que la pila está vacía
    }

    int elemento = cima.getDato();
    cima = cima.getSiguiente();
    return elemento;
  }

  // Método para mostrar los elementos de la pila
  public void view() {
    if (isEmpty()) {
      System.out.println("La pila está vacía");
      return;
    }

    Nodo actual = cima;
    StringBuilder elementos = new StringBuilder();

    // Creamos un arreglo temporal para almacenar los elementos en orden inverso
    // para mostrarlos del último agregado al primero (de arriba hacia abajo)
    Nodo temp = cima;
    int contador = 0;

    // Contamos cuántos elementos hay
    while (temp != null) {
      contador++;
      temp = temp.getSiguiente();
    }

    // Creamos un arreglo del tamaño adecuado
    int[] elementosArray = new int[contador];

    // Almacenamos los elementos en el arreglo
    temp = cima;
    for (int i = 0; i < contador; i++) {
      elementosArray[i] = temp.getDato();
      temp = temp.getSiguiente();
    }

    // Construimos la cadena para mostrar los elementos
    for (int i = 0; i < contador; i++) {
      elementos.append(elementosArray[i]);

      if (i < contador - 1) {
        elementos.append(", ");
      }
    }

    System.out.println(elementos.toString());
  }

  // Método para verificar si la pila está vacía
  public boolean isEmpty() {
    return cima == null;
  }
}

// Nodos enlazados para mantener la estructura de la pila
class Nodo {
  private int dato;
  private Nodo siguiente;

  public Nodo(int dato) {
    this.dato = dato;
    this.siguiente = null;
  }

  // Se tiene un puntero al frente de la pila
  public int getDato() {
    return dato;
  }

  // Se tiene un puntero al final de la pila
  public Nodo getSiguiente() {
    return siguiente;
  }

  // agregan al final al final los nuevos elementos de la pila
  public void setSiguiente(Nodo siguiente) {
    this.siguiente = siguiente;
  }
}