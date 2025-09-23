 import java.util.ArrayList;
import java.util.Scanner;

class Tarea {
    private String descripcion;
    private String estado;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.estado = "pendiente"; // Estado inicial
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void marcarCompletada() {
        this.estado = "completada";
    }
}

public class GestorTareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarea> listaTareas = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n--- Menú de Gestión de Tareas ---");
            System.out.println("1. Añadir una nueva tarea");
            System.out.println("2. Marcar una tarea como completada");
            System.out.println("3. Mostrar todas las tareas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch(opcion) {
                case 1:
                    System.out.print("Ingrese la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    listaTareas.add(new Tarea(descripcion));
                    System.out.println("Tarea añadida correctamente.");
                    break;

                case 2:
                    if (listaTareas.isEmpty()) {
                        System.out.println("No hay tareas para marcar como completadas.");
                        break;
                    }
                    System.out.print("Ingrese el número de la tarea a marcar como completada: ");
                    int numTarea = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    if (numTarea > 0 && numTarea <= listaTareas.size()) {
                        Tarea tarea = listaTareas.get(numTarea - 1);
                        tarea.marcarCompletada();
                        System.out.println("Tarea marcada como completada.");
                    } else {
                        System.out.println("Número de tarea inválido.");
                    }
                    break;

                case 3:
                    if (listaTareas.isEmpty()) {
                        System.out.println("No hay tareas para mostrar.");
                    } else {
                        System.out.println("\nLista de tareas:");
                        for (int i = 0; i < listaTareas.size(); i++) {
                            Tarea tarea = listaTareas.get(i);
                            System.out.println((i + 1) + ". " + tarea.getDescripcion() + " [" + tarea.getEstado() + "]");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}



