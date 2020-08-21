package hackerrank_challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 *
 * @see - https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
public class DiagonalDifference {


    public static void main(String[] args) {
//        List<Integer> l1 = Arrays.asList(11, 2, 4);
//        List<Integer> l2 = Arrays.asList(4, 5, 6);
//        List<Integer> l3 = Arrays.asList(10, 8, -12);

        List<Integer> l1 = Arrays.asList(1, 2, 5, 4);
        List<Integer> l2 = Arrays.asList(2, 0, 3, 9);
        List<Integer> l3 = Arrays.asList(8, 1, 7, 6);
        List<Integer> l4 = Arrays.asList(6, 6, 2, 3);

        List<List<Integer>> matriz = Arrays.asList(l1, l2, l3, l4);
        int absoluteDiff = diagonalDifference(matriz);
        System.out.println(absoluteDiff);
    }

    // Complete the birthdayCakeCandles function below.
    public static int diagonalDifference(List<List<Integer>> arr) {
        if (arr.isEmpty())
            return 0;

        int n = arr.get(0).size();
        List<Integer> listaAplanada = arr.stream().flatMap(List::stream).collect(Collectors.toList());

        List<Integer> indicesDiagonal = IntStream.iterate(0, i -> i + n + 1).limit(n).boxed().collect(Collectors.toList());
        int sumaDiagonal = indicesDiagonal.stream().mapToInt(listaAplanada::get).sum();
        List<Integer> indicesDiagonalOpuesta = IntStream.iterate(n - 1, i -> i + n - 1).limit(n).boxed().collect(Collectors.toList());
        int sumaDiagonalOpuesta = indicesDiagonalOpuesta.stream().mapToInt(listaAplanada::get).sum();
        return Math.abs(sumaDiagonal - sumaDiagonalOpuesta);
    }

}
