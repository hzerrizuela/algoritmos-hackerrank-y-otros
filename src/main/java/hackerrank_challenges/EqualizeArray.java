package hackerrank_challenges;

import java.text.CollationElementIterator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Karl has an array of integers. He wants to reduce the array until all remaining elements are equal.
 * Determine the minimum number of elements to delete to reach his goal.
 *
 * @see - https://www.hackerrank.com/challenges/equality-in-a-array/problem
 */
public class EqualizeArray {


    public static void main(String[] args) throws Exception {

//        int arr[] = {1, 2, 2, 3}; // 2
//        int arr[] = {1, 2, 2, 3, 5, 5}; // 4
//        int arr[] = {1, 4, 2, 3}; // 3
//        int arr[] = {1, 1, 1, 1}; // 0
        int arr[] = {1, 1, 1, 1, 9}; // 1
//        int arr[] = {1, 1, 2, 2}; // 2
        Integer minNumberDeletions = equalizeArray(arr);
        System.out.println("Min num of deletions: " + minNumberDeletions);

    }

    /**
     * Σ de los values del Map<N°, frecuencia> una vez que elimine la entrada de mayor frequencia
     * @param arr
     * @return
     */
    private static int equalizeArray(int[] arr) {
        List<Integer> integers = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Map<Integer, Long> mapaFrequencia = integers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Integer key = Collections.max(mapaFrequencia.entrySet(), Comparator.comparingLong(Map.Entry::getValue)).getKey();

        mapaFrequencia.remove(key);
        return mapaFrequencia.values().stream().reduce(0L, Long::sum).intValue();
//        return (int) mapaFrequencia.values().stream().mapToLong(v -> v).sum(); // otra opción...
    }


}
