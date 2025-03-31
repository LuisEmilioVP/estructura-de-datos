import java.util.Scanner;
/*
 * Clase principal con el menú
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 30/03/2025
 */

public class ListaEnlazadaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista lista = new Lista();
        int opcion = 0;

        do {
            System.out.println("\nMenu de Opcion:");
            System.out.println("1- Agregar elementos a la lista");
            System.out.println("2- Eliminar elementos de la lista");
            System.out.println("3- Mostrar los elementos de la lista");
            System.out.println("4- Salir");
            System.out.println("-------------------------------------------------");
            System.out.print("Seleccione la opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Digite el valor que desea agregar a la lista: ");
                    int valorAgregar = scanner.nextInt();
                    lista.add(valorAgregar);
                    break;

                case 2:
                    System.out.print("Digite el valor que desea eliminar de la lista: ");
                    int valorEliminar = scanner.nextInt();
                    lista.delete(valorEliminar);
                    break;

                case 3:
                    lista.print();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}
