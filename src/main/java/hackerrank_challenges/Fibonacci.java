package hackerrank_challenges;

/**
 * Buscar el "n" elemento de la sucesion de Fibonacci
 * Fibonacci = 1, 1, 2, 3, 5, 8, 13, 21...
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacciRecursivo(6));
//        System.out.println(fibonacci(6));
        System.out.println(nthFibonacciTerm(6));
    }

    /**
     * Debe retornar el elemento en la posicion n de la serie de fibonacci
     *
     * @param n
     */
    private static Integer fibonacciRecursivo(int n) {
        if (n <= 2) return 1;
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }


    /**
     * Sucesión fibonacci iterativo en Java
     *
     * @author parzibyte
     */
    public static long fibonacci(long posicion) {
        int siguiente = 1;
        int actual = 0;
        int temporal = 0;
        for (int x = 1; x <= posicion; x++) {
            // Si no quieres imprimirla, comenta la siguiente línea:
            System.out.print(actual + ", ");
            temporal = actual;
            actual = siguiente;
            siguiente = siguiente + temporal;
        }
        // Si no quieres imprimirla, comenta la siguiente línea:
        System.out.println(actual);
        return actual;
    }

    public static int nthFibonacciTerm(int n) {
        double squareRootOf5 = Math.sqrt(5);
        double phi = (1 + squareRootOf5) / 2;
        int nthTerm = (int) ((Math.pow(phi, n) - Math.pow(-phi, -n)) / squareRootOf5);
        return nthTerm;
    }

}
