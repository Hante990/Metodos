package Jacobi;

public class Jacobi1 {
    // Definimos un umbral de error para la convergencia del método
    public static final double EPSILON = 0.0001;
    
    // Número máximo de iteraciones para evitar bucles infinitos en caso de no convergencia
    public static final int MAX_ITERATIONS = 100;

    public static void main(String[] args) {
        // Matriz de coeficientes del sistema de ecuaciones
        double[][] coefficients = {
            {5, 1, 1}, 
            {1, 4, 1}, 
            {2, 1, 3}
        }; 
        
        // Vector de términos independientes
        double[] constants = {10, 11, 12}; 

        // Llamamos al método que resuelve el sistema con el método de Jacobi
        double[] solution = solveJacobi(coefficients, constants);
        
        // Imprimimos la solución obtenida
        System.out.println("Solución encontrada:");
        for (int i = 0; i < solution.length; i++) {
            System.out.println("x" + (i + 1) + " = " + solution[i]);
        }
    }

    /**
     * Método que implementa el método iterativo de Jacobi para resolver un sistema de ecuaciones lineales.
     */
    public static double[] solveJacobi(double[][] coefficients, double[] constants) {
        int n = constants.length; // Número de ecuaciones (o incógnitas)
        double[] solution = new double[n]; // Vector de soluciones inicializado en 0
        double[] nextSolution = new double[n]; // Vector auxiliar para la siguiente iteración
        int iterations = 0; // Contador de iteraciones
        boolean converged = false; // Bandera para determinar si el método ha convergido

        // Iteramos hasta alcanzar la convergencia o el número máximo de iteraciones
        while (!converged && iterations < MAX_ITERATIONS) {
            for (int i = 0; i < n; i++) { // Recorre cada ecuación
                double sum = constants[i]; // Inicia con el término independiente
                for (int j = 0; j < n; j++) { // Recorre los coeficientes de la ecuación
                    if (j != i) { // No se toma en cuenta el coeficiente de la incógnita actual
                        sum -= coefficients[i][j] * solution[j];
                    }
                }
                nextSolution[i] = sum / coefficients[i][i]; // Calcula la nueva aproximación de la incógnita
            }

            // Verificamos la diferencia entre la iteración actual y la anterior para evaluar la convergencia
            double maxDifference = 0.0;
            for (int i = 0; i < n; i++) {
                double difference = Math.abs(nextSolution[i] - solution[i]);
                if (difference > maxDifference) {
                    maxDifference = difference;
                }
            }

            // Si la diferencia máxima es menor que el umbral EPSILON, el método ha convergido
            if (maxDifference < EPSILON) {
                converged = true;
            }

            // Copiamos los valores de la nueva iteración en la solución actual
            for (int i = 0; i < n; i++) {
                solution[i] = nextSolution[i];
            }

            iterations++; // Incrementamos el contador de iteraciones
        }

        // Si se alcanzó el número máximo de iteraciones sin convergencia, se informa al usuario
        if (iterations == MAX_ITERATIONS) {
            System.out.println("El método no converge después de " + MAX_ITERATIONS + " iteraciones.");
        }

        return solution; // Retorna la solución obtenida
    }
}
