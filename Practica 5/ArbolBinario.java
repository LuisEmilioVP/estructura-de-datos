/*
 * Clase Nodo del Árbol Binario
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 12/04/2025
 */

public class ArbolBinario {
  private Nodo raiz;

  public ArbolBinario() {
    this.raiz = null;
  }

  // Método público para agregar un valor al árbol
  public void agregar(int valor) {
    raiz = agregarRecursivo(raiz, valor);
  }

  // Método recursivo para agregar un valor
  private Nodo agregarRecursivo(Nodo nodo, int valor) {
    // Si el nodo es nulo, crear un nuevo nodo
    if (nodo == null) {
      return new Nodo(valor);
    }

    // Si el valor es menor que el valor del nodo, ir a la izquierda
    if (valor < nodo.valor) {
      nodo.izquierdo = agregarRecursivo(nodo.izquierdo, valor);
    }
    // Si el valor es mayor que el valor del nodo, ir a la derecha
    else if (valor > nodo.valor) {
      nodo.derecho = agregarRecursivo(nodo.derecho, valor);
    }
    // Si el valor ya existe, no se añade (evita duplicados)
    return nodo;
  }

  // Método público para recorrido InOrden
  public void recorridoInOrden() {
    System.out.print("Recorrido InOrden: ");
    inOrdenRecursivo(raiz);
    System.out.println();
  }

  // Método recursivo para recorrido InOrden (Izquierdo, Raíz, Derecho)
  private void inOrdenRecursivo(Nodo nodo) {
    if (nodo != null) {
      inOrdenRecursivo(nodo.izquierdo);
      System.out.print(nodo.valor + " ");
      inOrdenRecursivo(nodo.derecho);
    }
  }

  // Método público para recorrido PreOrden
  public void recorridoPreOrden() {
    System.out.print("Recorrido PreOrden: ");
    preOrdenRecursivo(raiz);
    System.out.println();
  }

  // Método recursivo para recorrido PreOrden (Raíz, Izquierdo, Derecho)
  private void preOrdenRecursivo(Nodo nodo) {
    if (nodo != null) {
      System.out.print(nodo.valor + " ");
      preOrdenRecursivo(nodo.izquierdo);
      preOrdenRecursivo(nodo.derecho);
    }
  }

  // Método público para recorrido PostOrden
  public void recorridoPostOrden() {
    System.out.print("Recorrido PostOrden: ");
    postOrdenRecursivo(raiz);
    System.out.println();
  }

  // Método recursivo para recorrido PostOrden (Izquierdo, Derecho, Raíz)
  private void postOrdenRecursivo(Nodo nodo) {
    if (nodo != null) {
      postOrdenRecursivo(nodo.izquierdo);
      postOrdenRecursivo(nodo.derecho);
      System.out.print(nodo.valor + " ");
    }
  }
}