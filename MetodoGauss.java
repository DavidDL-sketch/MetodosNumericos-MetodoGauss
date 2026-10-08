/**
 * Práctica: Método de Gauss
 * Asignatura: Métodos Numéricos (SCC-1017)
 * Diseño: Modular, limpio y documentado.
 */
public class MetodoGauss {

    public static void main(String[] args) {
        // --- DISEÑO VISIBLE DE LA MATRIZ 3x3 (Matriz Aumentada) ---
        // El sistema representa:
        //  2x + 1y - 1z =  8
        // -3x - 1y + 2z = -11
        // -2x + 1y + 2z = -3
        double[][] matrizAumentada = {
                { 2.0,  1.0, -1.0,   8.0},
                {-3.0, -1.0,  2.0, -11.0},
                {-2.0,  1.0,  2.0,  -3.0}
        };

        System.out.println("=== MATRIZ INICIAL (SISTEMA DE ECUACIONES) ===");
        imprimirMatriz(matrizAumentada);

        // Resolver usando el método de Gauss
        double[] soluciones = resolverGauss(matrizAumentada);

        // Mostrar resultados si el sistema tiene solución única
        if (soluciones != null) {
            System.out.println("\n=== SOLUCIÓN DEL SISTEMA ===");
            System.out.printf("x = %.4f%n", soluciones[0]);
            System.out.printf("y = %.4f%n", soluciones[1]);
            System.out.printf("z = %.4f%n", soluciones[2]);
        }
    }

    /**
     * Módulo encargado de aplicar la eliminación de Gauss y sustitución hacia atrás.
     * @param matriz Matriz aumentada de tamaño Nx(N+1)
     * @return Arreglo con las soluciones de las variables.
     */
    public static double[] resolverGauss(double[][] matriz) {
        int n = matriz.length;

        // 1. Etapa de Eliminación Hacia Adelante (Triangularización)
        for (int i = 0; i < n; i++) {
            // Pivoteo parcial simple (para evitar división por cero o mejorar precisión)
            int max = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matriz[k][i]) > Math.abs(matriz[max][i])) {
                    max = k;
                }
            }
            // Intercambiar filas si es necesario
            double[] temp = matriz[i];
            matriz[i] = matriz[max];
            matriz[max] = temp;

            // Verificar si el sistema tiene solución única
            if (Math.abs(matriz[i][i]) < 1e-9) {
                System.out.println("\nError: El sistema no tiene solución única (pivote cercano a cero).");
                return null;
            }

            // Hacer ceros debajo del pivote actual
            for (int j = i + 1; j < n; j++) {
                double factor = matriz[j][i] / matriz[i][i];
                for (int k = i; k <= n; k++) {
                    matriz[j][k] -= factor * matriz[i][k];
                }
            }
        }

        System.out.println("\n=== MATRIZ TRIANGULAR SUPERIOR OBTENIDA ===");
        imprimirMatriz(matriz);

        // 2. Etapa de Sustitución Hacia Atrás
        double[] soluciones = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double suma = 0.0;
            for (int j = i + 1; j < n; j++) {
                suma += matriz[i][j] * soluciones[j];
            }
            soluciones[i] = (matriz[i][n] - suma) / matriz[i][i];
        }

        return soluciones;
    }

    /**
     * Módulo auxiliar para imprimir la matriz de manera legible en consola.
     * @param matriz Matriz a mostrar.
     */
    public static void imprimirMatriz(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int i = 0; i < filas; i++) {
            System.out.print("[ ");
            for (int j = 0; j < columnas; j++) {
                // Separa visualmente la columna de los términos independientes
                if (j == columnas - 1) {
                    System.out.print("| ");
                }
                System.out.printf("%8.2f ", matriz[i][j]);
            }
            System.out.println("]");
        }
    }
}