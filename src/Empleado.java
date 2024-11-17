import java.util.Scanner;

// empleado con nombre, ID y salario
public class Empleado {
    private String nombre;  // Nombre del empleado
    private int id;         // ID único del empleado
    private double salario; // Salario del empleado

    // inicializar un nuevo empleado
    public Empleado(String nombre, int id, double salario) {
        this.nombre = nombre;
        this.id = id;
        this.salario = salario;
    }


    public String getNombre() {
        return nombre;
    }


    public int getId() {
        return id;
    }


    public double getSalario() {
        return salario;
    }

    //detalles de un empleado en consola
    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre + ", ID: " + id + ", Salario: " + salario);
    }
}

// búsqueda de empleados
class Empresa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Para leer la entrada del usuario

        //  simular una base de datos
        Empleado[] empleados = {
                new Empleado("Juan Perez", 1, 500.0),
                new Empleado("Maria Lopez", 2, 700.0),
                new Empleado("Pedro Alvarez", 3, 450.0),
                new Empleado("David Eliezer", 4, 400.0),
                new Empleado("Beatriz Roxana", 5, 450.0),
                new Empleado("Kevin Rosales", 6, 500.0),
                new Empleado("Alvaro Lopes", 7, 600.0),
                new Empleado("Henry Adrian", 8, 400.0)
        };

        int opcion;

        // interactuar con el usuario
        do {
            System.out.println("Búsqueda Secuencial");
            System.out.println("\nMenú:");
            System.out.println("1. Buscar empleado por nombre");
            System.out.println("2. Buscar empleado por ID");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del empleado a buscar: ");
                    String nombre = scanner.nextLine();
                    Empleado empleadoPorNombre = buscarEmpleadoPorNombre(empleados, nombre);
                    if (empleadoPorNombre != null) {
                        System.out.println("Empleado encontrado:");
                        empleadoPorNombre.mostrarDetalles();
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el ID del empleado a buscar: ");
                    int id = scanner.nextInt();
                    Empleado empleadoPorID = buscarEmpleadoPorID(empleados, id);
                    if (empleadoPorID != null) {
                        System.out.println("Empleado encontrado:");
                        empleadoPorID.mostrarDetalles();
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();  // Cerrar el scanner
    }

    //buscar un empleado por su nombre
    public static Empleado buscarEmpleadoPorNombre(Empleado[] empleados, String nombre) {
        for (Empleado empleado : empleados) {
            // Compara si el nombre de cada empleado contiene la cadena ingresada, ignorando mayúsculas y minúsculas
            if (empleado.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                return empleado;
            }
        }
        return null;  // Si no se encuentra el empleado, devuelve null
    }

    // buscar un empleado por su ID
    public static Empleado buscarEmpleadoPorID(Empleado[] empleados, int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null;  // Si no se encuentra el empleado, devuelve null
    }
}
