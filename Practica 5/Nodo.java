/*
 * Clase Nodo del Árbol Binario
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 12/04/2025
 */

class Nodo {

  int valor;
  Nodo izquierdo;
  Nodo derecho;

  public Nodo(int valor) {
    this.valor = valor;
    this.izquierdo = null;
    this.derecho = null;
  }
}