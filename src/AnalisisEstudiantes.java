import java.util.Scanner;

public class AnalisisEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar cantidad de estudiantes
        System.out.print("Ingrese la cantidad de estudiantes: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea sobrante

        // Validar entrada
        if (n <= 0) {
            System.out.println("La cantidad de estudiantes debe ser mayor a cero.");
            return;
        }

        // Crear arreglos para nombres y notas
        String[] nombres = new String[n];
        int[] notas = new int[n];

        // Ingresar nombres y calificaciones
        for (int i = 0; i < n; i++) {
            do {
                System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
                nombres[i] = scanner.nextLine().trim();
            } while (nombres[i].isEmpty());

            do {
                System.out.print("Ingrese la nota de " + nombres[i] + " (0 a 100): ");
                notas[i] = scanner.nextInt();
                scanner.nextLine(); // Consumir la línea sobrante
            } while (notas[i] < 0 || notas[i] > 100);
        }

        // Encontrar la nota más alta y su índice
        int mejorNotaIndex = obtenerIndiceMaximo(notas);
        int mejorNota = notas[mejorNotaIndex];

        // Encontrar la nota más baja y su índice
        int peorNotaIndex = obtenerIndiceMinimo(notas);
        int peorNota = notas[peorNotaIndex];

        // Mostrar resultados
        System.out.println("\n--- Resultados ---");
        System.out.println("Mejor estudiante: " + nombres[mejorNotaIndex] + " con nota " + mejorNota);
        System.out.println("Peor estudiante: " + nombres[peorNotaIndex] + " con nota " + peorNota);

        scanner.close();
    }

    // Función para encontrar el índice del valor máximo
    public static int obtenerIndiceMaximo(int[] numeros) {
        int maxIndex = 0;
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > numeros[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Función para encontrar el índice del valor mínimo
    public static int obtenerIndiceMinimo(int[] numeros) {
        int minIndex = 0;
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] < numeros[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
