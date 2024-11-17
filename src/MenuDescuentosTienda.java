import java.util.Scanner;

public class MenuDescuentosTienda {
    public static void main(String[] args) {
        // Crear un objeto Scanner para recibir la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        int opcion; // Variable para almacenar la opción seleccionada por el usuario

        // Lista de productos y sus precios originales
        String[] productos = {"Laptop", "Televisor", "Celular", "Refrigerador", "Microondas"};
        double[] preciosOriginales = {800, 600, 300, 1200, 150}; // Precios originales de los productos

        // Bucle do-while para mostrar el menú hasta que el usuario seleccione la opción de salir
        do {
            // Mostrar el menú de opciones
            System.out.println("\n Algoritmo de burbuja ");
            System.out.println("\n--- Menú de Descuentos ---");
            System.out.println("1. Productos a mitad de precio");
            System.out.println("2. Productos al 25% de descuento");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt(); // Leer la opción del usuario

            // Dependiendo de la opción seleccionada, ejecutar una acción
            switch (opcion) {
                case 1:
                    // Opción 1: Mostrar productos con mitad de precio
                    System.out.println("\n--- Productos a Mitad de Precio ---");
                    for (int i = 0; i < productos.length; i++) {
                        double precioMitad = preciosOriginales[i] * 0.5; // Calcular el precio con 50% de descuento
                        // Imprimir el nombre del producto, precio original y precio con descuento
                        System.out.println(productos[i] + " - Precio original: $" + preciosOriginales[i] + " | Precio con 50% de descuento: $" + precioMitad);
                    }
                    break;

                case 2:
                    // Opción 2: Mostrar productos con 25% de descuento
                    System.out.println("\n--- Productos al 25% de Descuento ---");
                    for (int i = 0; i < productos.length; i++) {
                        double precioConDescuento = preciosOriginales[i] * 0.75; // Calcular el precio con 25% de descuento
                        // Imprimir el nombre del producto, precio original y precio con descuento
                        System.out.println(productos[i] + " - Precio original: $" + preciosOriginales[i] + " | Precio con 25% de descuento: $" + precioConDescuento);
                    }
                    break;

                case 3:
                    // Opción 3: Salir del programa
                    System.out.println("Gracias por visitar la tienda. ¡Hasta luego!");
                    break;

                default:
                    // Si el usuario ingresa una opción no válida
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 3); // Continuar mostrando el menú hasta que el usuario elija salir

        // Cerrar el objeto Scanner para evitar fugas de recursos
        scanner.close();
    }
}
