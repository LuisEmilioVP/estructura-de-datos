/*
 * Clase Lista con las operaciones requeridas
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 30/03/2025
 */

public class Lista {
    private Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }

    // Método para agregar un elemento a la lista
    public void add(int valor) {
        Nodo nuevoNodo = new Nodo(valor);

        if (cabeza == null) {
            // Si la lista está vacía, el nuevo nodo será la cabeza
            cabeza = nuevoNodo;
        } else {
            // Si la lista no está vacía, se recorre hasta el final
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            // Se agrega el nuevo nodo al final
            actual.siguiente = nuevoNodo;
        }
        System.out.println("Valor " + valor + " agregado a la lista.");
    }

    // Método para eliminar un elemento de la lista por su valor
    public void delete(int valor) {
        // Si la lista está vacía
        if (cabeza == null) {
            System.out.println("La lista está vacía, no se puede eliminar.");
            return;
        }

        // Si el valor a eliminar está en la cabeza
        if (cabeza.valor == valor) {
            cabeza = cabeza.siguiente;
            System.out.println("Valor " + valor + " eliminado de la lista.");
            return;
        }

        // Buscar el valor en el resto de la lista
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.valor != valor) {
            actual = actual.siguiente;
        }

        // Si se encontró el valor
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            System.out.println("Valor " + valor + " eliminado de la lista.");
        } else {
            System.out.println("El valor " + valor + " no existe en la lista.");
        }
    }

    // Método para imprimir todos los elementos de la lista
    public void print() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        System.out.print("Los elementos de la lista son: ");
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor);
            if (actual.siguiente != null) {
                System.out.print(", ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
