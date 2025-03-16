package Gauss_Jordan;

public class GaussJordan {

    public static void main(String[] args) {
        System.out.println("GAUSS-JORDAN");

        // Matriz aumentada del sistema de ecuaciones
        double[][] matriz = {   
            {4, 2, -2, 1},
            {10, 4, 4, -4},
            {6, 2, 2, 5}    
        };

        // Llamamos al método que realiza la eliminación de Gauss-Jordan
        double[][] resultados = operaciones(matriz);

        // Mostramos los resultados obtenidos
        Resultados(resultados);
    }

    /**
     * Método que aplica el algoritmo de Gauss-Jordan para resolver el sistema de ecuaciones.
     *
     * @param matriz Matriz aumentada del sistema de ecuaciones
     * @return Matriz transformada con los resultados de las incógnitas
     */
    public static double[][] operaciones(double[][] matriz) {
        int fila = matriz.length; // Número de filas (ecuaciones)
        int columna = matriz[0].length; // Número de columnas (incógnitas + términos independientes)

        // Aplicamos la eliminación de Gauss-Jordan
        for (int i = 0; i < fila; i++) {
            double pivote = matriz[i][i]; // Seleccionamos el pivote
            for (int j = i + 1; j < columna; j++) { // Normalizamos la fila dividiendo por el pivote
                matriz[i][j] /= pivote;
            }
            matriz[i][i] = 1; // Convertimos el pivote en 1

            // Eliminamos los valores en la columna del pivote en las demás filas
            for (int j = 0; j < fila; j++) {
                if (i != j) { // Evitamos operar con la misma fila
                    double factor = matriz[j][i]; // Factor para la eliminación
                    for (int k = i; k < columna; k++) { // Restamos la fila actual escalada
                        matriz[j][k] -= factor * matriz[i][k];
                    }
                }
            }
        }

        return matriz; // Retornamos la matriz transformada
    }

    /**
     * Método para imprimir los resultados obtenidos.
     */
    public static void Resultados(double[][] matriz) {
        System.out.println("Los resultados son: ");
        System.out.println("X = " + matriz[0][3] + " :)");
        System.out.println("Y = " + matriz[1][3] + " :)");
        System.out.println("Z = " + matriz[2][3] + " :)"); // Corregido, antes había una doble 'Y'
    }
}
