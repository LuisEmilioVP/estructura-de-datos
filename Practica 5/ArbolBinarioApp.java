/*
 * Clase principal para ejecutar el programa
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 12/04/2025
 */

public class ArbolBinarioApp {
  public static void main(String[] args) {
    // Crear un nuevo árbol binario
    ArbolBinario arbol = new ArbolBinario();

    // Datos a almacenar en el árbol
    int[] datos = { 45, 23, 15, 65, 12, 50, 80, 18, 24, 33, 55, 20, 70 };

    // Agregar los elementos al árbol
    System.out.println("Agregando elementos al árbol:");
    for (int dato : datos) {
      System.out.println("Agregando: " + dato);
      arbol.agregar(dato);
    }

    System.out.println("\n--- Resultados de los recorridos ---");

    // Realizar los recorridos
    arbol.recorridoInOrden();
    arbol.recorridoPreOrden();
    arbol.recorridoPostOrden();
  }
}
