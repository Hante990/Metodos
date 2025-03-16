package Seidel;

public class GausseSeidel1 {

    public static void main(String[] args) {
        // Matriz de coeficientes del sistema de ecuaciones
        double[][] A = {
                {4.0, -1.0, 0.0},
                {-1.0, 4.0, -1.0},
                {0.0, -1.0, 4.0}
        };

        // Vector de términos independientes
        double[] b = {1, -4, 5};

        // Llamamos al método que resuelve el sistema con el método de Gauss-Seidel
        double[] x = gaussSeidel(A, b);

        // Imprimimos la solución obtenida
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }

        // Mensaje explicando el redondeo debido a la tolerancia en los puntos decimales
        System.out.println("Me da ese redondeo por la tolerancia de los puntos decimales.");
    }

    /**s
     * Método que implementa el algoritmo de Gauss-Seidel para resolver un sistema de ecuaciones lineales.
     */
    public static double[] gaussSeidel(double[][] A, double[] b) {
        int n = A.length; // Número de ecuaciones o incógnitas
        double[] x = new double[n]; // Vector de soluciones inicializado en 0
        double[] newX = new double[n]; // Vector auxiliar para la siguiente iteración
        int max = 100; // Número máximo de iteraciones
        double epsilon = 1e-50; // Tolerancia para la convergencia

        // Iteramos hasta alcanzar la convergencia o el número máximo de iteraciones
        for (int iter = 0; iter < max; iter++) {
            for (int i = 0; i < n; i++) { // Recorre cada ecuación
                newX[i] = b[i]; // Inicia con el término independiente
                for (int j = 0; j < n; j++) { // Recorre los coeficientes de la ecuación
                    if (j != i) { // No toma en cuenta el coeficiente de la incógnita actual
                        newX[i] -= A[i][j] * x[j];
                    }
                }
                newX[i] /= A[i][i]; // Calcula la nueva aproximación de la incógnita
            }

            // Verificamos si la solución ha convergido
            boolean stop = true;
            for (int i = 0; i < n; i++) {
                if (Math.abs(newX[i] - x[i]) > epsilon) { // Compara el cambio con la tolerancia
                    stop = false;
                    break;
                }
            }

            // Si la diferencia máxima es menor que epsilon, el método ha convergido
            if (stop) {
                break;
            }

            // Copiamos los valores de la nueva iteración en la solución actual
            System.arraycopy(newX, 0, x, 0, n);
        }

        return x; // Retorna la solución obtenida
    }
}
