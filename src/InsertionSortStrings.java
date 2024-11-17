import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortStrings {
    public static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String current = arr[i];
            int j = i - 1;

            // Mover elementos mayores hacia la derecha (sin distinguir mayúsculas/minúsculas)
            while (j >= 0 && arr[j].compareToIgnoreCase(current) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insertar el elemento en su posición correcta
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAlgoritmo de ordenamiento por inserción\n");

        System.out.print("¿Cuántos nombres deseas ordenar? ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el entero

        String[] names = new String[n];
        System.out.println("Ingresa los nombres:");
        for (int i = 0; i < n; i++) {
            System.out.print("Nombre " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        System.out.println("Antes de ordenar: " + Arrays.toString(names));

        insertionSort(names);

        System.out.println("Después de ordenar: " + Arrays.toString(names));

        scanner.close();
    }
}
