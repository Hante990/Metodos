package Eliminacion_Gaussiana;

public class Ejercicio1 {

    public static void main(String[] args) {
        int n = 3; // Número de incógnitas en el sistema de ecuaciones

        // Matriz aumentada que representa el sistema de ecuaciones:
        //  2x +  y -  z =  8
        // -3x -  y + 2z = -11
        // -2x +  y + 2z = -3
        double[][] matrix = {
                {2.0, 1.0, -1.0, 8.0},
                {-3.0, -1.0, 2.0, -11.0},
                {-2.0, 1.0, 2.0, -3.0}
        };

        // Llamada al método que resuelve el sistema mediante eliminación gaussiana
        double[] result = Eliminacion(matrix, n);

        // Imprime los valores de las incógnitas obtenidas
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] = " + result[i]);
        }
    }

    /**
     * Método que implementa el algoritmo de Eliminación Gaussiana
     * para resolver un sistema de ecuaciones lineales.
     */
    public static double[] Eliminacion(double[][] matrix, int n) {
        // Proceso de eliminación hacia adelante
        for (int i = 0; i < n; i++) { // Recorre cada fila
            for (int j = i + 1; j < n; j++) { // Recorre las filas inferiores
                double factor = matrix[j][i] / matrix[i][i]; // Calcula el factor de eliminación
                
                // Modifica la fila restando un múltiplo de la fila superior
                for (int k = i; k < n + 1; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }

        // Proceso de sustitución regresiva para encontrar las soluciones
        double[] result = new double[n]; // Arreglo que almacenará las soluciones
        for (int i = n - 1; i >= 0; i--) { // Recorre las filas en orden inverso
            result[i] = matrix[i][n]; // Toma el valor independiente

            for (int j = i + 1; j < n; j++) { // Sustituye los valores ya calculados
                result[i] -= matrix[i][j] * result[j];
            }
            result[i] /= matrix[i][i]; // Despeja la incógnita
        }

        return result; // Retorna el conjunto de soluciones
    }
}
