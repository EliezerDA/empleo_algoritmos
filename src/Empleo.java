import java.util.Scanner;

// la información de cada puesto de trabajo
public class Empleo {
    private String nombre;
    private int id;
    private double salario;

    //inicializar los atributos de cada empleo
    public Empleo(String nombre, int id, double salario) {
        this.nombre = nombre;
        this.id = id;
        this.salario = salario;
    }

    // obtener el id del empleo
    public int getId() {
        return id;
    }

    // nombre del empleo
    public String getNombre() {
        return nombre;
    }

    // los detalles de un empleo en formato legible
    public void mostrarDetalles() {
        System.out.println("ID: " + id + ", Puesto: " + nombre + ", Salario: $" + salario);
    }
}

//  SistemaEmpleos que gestiona las funcionalidades de búsqueda y menú
class SistemaEmpleos {

    public static void main(String[] args) {
        // Empleo que simula una base de datos de empleos
        Empleo[] empleos = {
                new Empleo("Ingeniero de Software", 101, 3000),
                new Empleo("Analista de Datos", 102, 2500),
                new Empleo("Desarrollador Web", 103, 2800),
                new Empleo("Gerente de Proyecto", 104, 4000),
                new Empleo("Soporte Técnico", 105, 1800),
                new Empleo("Especialista en Redes", 106, 2700),
                new Empleo("Diseñador UX/UI", 107, 2900),
                new Empleo("Administrador de Sistemas", 108, 3200),
                new Empleo("Product Manager", 109, 3500),
                new Empleo("Consultor de IT", 110, 3000)
        };

        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Bucle principal para el menú interactivo
        do {
            System.out.println("\nbúsqueda binaria");
            System.out.println("\nMenu de Empleos:");
            System.out.println("1. Ver todos los empleos disponibles");
            System.out.println("2. Buscar empleo por ID");
            System.out.println("3. Buscar empleo por nombre");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            // Opciones del menú
            switch (opcion) {
                case 1:
                    // mostrar todos los empleos disponibles
                    System.out.println("\nLista de Empleos Disponibles:");
                    for (Empleo empleo : empleos) {
                        empleo.mostrarDetalles();
                    }
                    break;
                case 2:
                    // Buscar empleo por ID usando búsqueda binaria
                    System.out.print("Ingrese el ID del empleo que desea buscar: ");
                    int id = scanner.nextInt();
                    Empleo resultadoID = buscarEmpleoPorID(empleos, id);
                    if (resultadoID != null) {
                        System.out.println("\nEmpleo Encontrado:");
                        resultadoID.mostrarDetalles();
                    } else {
                        System.out.println("Empleo no encontrado.");
                    }
                    break;
                case 3:
                    // Buscar empleo por nombre usando búsqueda secuencial
                    System.out.print("Ingrese el nombre del empleo que desea buscar: ");
                    String nombre = scanner.nextLine();
                    Empleo resultadoNombre = buscarEmpleoPorNombre(empleos, nombre);
                    if (resultadoNombre != null) {
                        System.out.println("\nEmpleo Encontrado:");
                        resultadoNombre.mostrarDetalles();
                    } else {
                        System.out.println("Empleo no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close(); // Cerrar el scanner para liberar recursos
    }

    // búsqueda binaria para encontrar un empleo por ID
    public static Empleo buscarEmpleoPorID(Empleo[] empleos, int id) {
        int inicio = 0;
        int fin = empleos.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (empleos[medio].getId() == id) {
                return empleos[medio];
            } else if (empleos[medio].getId() < id) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return null; // Si no se encuentra el empleo
    }

    //búsqueda secuencial para encontrar un empleo por nombre
    public static Empleo buscarEmpleoPorNombre(Empleo[] empleos, String nombre) {
        for (Empleo empleo : empleos) {
            if (empleo.getNombre().equalsIgnoreCase(nombre)) {
                return empleo;
            }
        }
        return null; // Si no se encuentra el empleo
    }
}
