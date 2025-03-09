/*
 * Gestion de Turnos
 * 
 * @author: Luis Emilio Valenzuela
 * @matricula: 100661550
 * @version: 1.0
 * @since: 09/03/2025
 */

package Programa_Turnos;

import java.util.Scanner;

public class GestionTurnos {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    ColaTutorias cola = new ColaTutorias();
    int opcion;

    System.out.println("===== SISTEMA DE GESTIÓN DE TURNOS - SALA DE TUTORÍAS =====");

    do {
      System.out.println("\nMenú Principal:");
      System.out.println("1. Registrar estudiante en espera");
      System.out.println("2. Atender próximo estudiante");
      System.out.println("3. Mostrar lista de espera");
      System.out.println("4. Salir");
      System.out.print("Seleccione una opción: ");

      opcion = scanner.nextInt();
      scanner.nextLine(); // Consumir salto de línea

      switch (opcion) {
        case 1:
          registrarEstudiante(cola, scanner);
          break;
        case 2:
          atenderEstudiante(cola);
          break;
        case 3:
          mostrarListaEspera(cola);
          break;
        case 4:
          System.out.println("¡Gracias por usar el sistema de gestión de turnos!");
          break;
        default:
          System.out.println("Opción no válida. Por favor, intente nuevamente.");
      }

    } while (opcion != 4);

    scanner.close();
  }

  // Registro de estudiantes
  private static void registrarEstudiante(ColaTutorias cola, Scanner scanner) {
    System.out.print("Ingrese la matricula del estudiante: ");
    String matricula = scanner.nextLine();

    System.out.print("Ingrese el nombre del estudiante: ");
    String nombre = scanner.nextLine();

    System.out.print("Ingrese la materia para la tutoría: ");
    String materia = scanner.nextLine();

    Estudiantes estudiante = new Estudiantes(matricula, nombre, materia);
    cola.agregarEstudiante(estudiante);

    System.out.println("\n¡Estudiante registrado con éxito!");
    System.out.println("Turno asignado: " + estudiante.getTurnos());
    System.out
        .println("Espere a ser llamado. Actualmente hay " + cola.cantidadEstudiantes() + " estudiante(s) en espera.");
  }

  // Atención de estudiantes
  private static void atenderEstudiante(ColaTutorias cola) {
    if (cola.estaVacia()) {
      System.out.println("No hay estudiantes en espera. ¡Todos han sido atendidos!");
      return;
    }

    Estudiantes estudiante = cola.atenderEstudiante();
    System.out.println("\n=== ATENDIENDO ESTUDIANTE ===");
    System.out.println("Se está atendiendo a: " + estudiante.getNombre());
    System.out.println("Turno: " + estudiante.getTurnos());
    System.out.println("Materia: " + estudiante.getMateria());
    System.out.println("¡El estudiante ha sido atendido con éxito!");

    if (!cola.estaVacia()) {
      Estudiantes siguiente = cola.verProximoEstudiante();
      System.out.println("\nPróximo estudiante a ser atendido: " + siguiente.getMatricula() + " - "
          + siguiente.getNombre() + " (Turno: " + siguiente.getTurnos() + ")");
    } else {
      System.out.println("\nNo hay más estudiantes en espera.");
    }
  }

  private static void mostrarListaEspera(ColaTutorias cola) {
    if (cola.estaVacia()) {
      System.out.println("No hay estudiantes en espera. ¡La sala está vacía!");
      return;
    }

    System.out.println("\n=== LISTA DE ESTUDIANTES EN ESPERA ===");
    cola.mostrarEstudiantes();
    System.out.println("Total de estudiantes en espera: " + cola.cantidadEstudiantes());
  }
}

// Estructura representativa para lios estudiantes
class Estudiantes {
  private static int contadorTurnos = 1;

  private String matricula;
  private String nombre;
  private String materia;
  private int turno;

  // Constructor
  public Estudiantes(String matricula, String nombre, String materia) {
    this.matricula = matricula;
    this.nombre = nombre;
    this.materia = materia;
    this.turno = contadorTurnos++;
  }

  // Obtener datos
  public String getMatricula() {
    return matricula;
  }

  public String getMateria() {
    return materia;
  }

  public String getNombre() {
    return nombre;
  }

  public int getTurnos() {
    return turno;
  }
}

// Nodo para gestionar los estudiantes
class NodoEstudinates {
  private Estudiantes estudiante;
  private NodoEstudinates siguiente;

  public NodoEstudinates(Estudiantes estudiante) {
    this.estudiante = estudiante;
    this.siguiente = null;
  }

  public Estudiantes getEstudiante() {
    return estudiante;
  }

  public NodoEstudinates getSiguiente() {
    return siguiente;
  }

  public void setSiguiente(NodoEstudinates siguiente) {
    this.siguiente = siguiente;
  }
}

// Estructura de cola para las tutorias
class ColaTutorias {
  private NodoEstudinates frente;
  private NodoEstudinates final_;
  private int cantidad;

  public ColaTutorias() {
    this.frente = null;
    this.final_ = null;
    this.cantidad = 0;
  }

  // Método para agregar un estudiante a la cola
  public void agregarEstudiante(Estudiantes estudiante) {
    NodoEstudinates nuevoNodo = new NodoEstudinates(estudiante);

    if (estaVacia()) {
      frente = nuevoNodo;
    } else {
      final_.setSiguiente(nuevoNodo);
    }

    final_ = nuevoNodo;
    cantidad++;
  }

  // Método para atender al próximo estudiante (eliminar de la cola)
  public Estudiantes atenderEstudiante() {
    if (estaVacia()) {
      return null;
    }

    Estudiantes estudiante = frente.getEstudiante();
    frente = frente.getSiguiente();

    if (frente == null) {
      final_ = null;
    }

    cantidad--;
    return estudiante;
  }

  // Método para ver el próximo estudiante sin eliminarlo
  public Estudiantes verProximoEstudiante() {
    if (estaVacia()) {
      return null;
    }

    return frente.getEstudiante();
  }

  // Método para mostrar todos los estudiantes en la cola
  public void mostrarEstudiantes() {
    if (estaVacia()) {
      System.out.println("No hay estudiantes en espera.");
      return;
    }

    NodoEstudinates actual = frente;
    int posicion = 1;

    while (actual != null) {
      Estudiantes est = actual.getEstudiante();
      System.out.println(posicion + ". Nombre: " + est.getNombre() +
          " | Turno: " + est.getTurnos() +
          " | Materia: " + est.getMateria());

      actual = actual.getSiguiente();
      posicion++;
    }
  }

  // Método para verificar si la cola está vacía
  public boolean estaVacia() {
    return frente == null;
  }

  // Método para obtener la cantidad de estudiantes en espera
  public int cantidadEstudiantes() {
    return cantidad;
  }
}