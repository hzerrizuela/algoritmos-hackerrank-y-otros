package avaya.codility;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Demo exercise
 * Encontrar el numero positivo más alto que NO esté contenido en la lista input.
 * De no haber ninguno, devolver 1.
 *       For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *       given A = [1, 5, 6], the function should return 4
 *       Given A = [1, 2, 3], the function should return 4.
 *       Given A = [−1, −3], the function should return 1.
 *
 * @see - https://app.codility.com/
 */
public class NotContainedPositiveInteger {

    public static void main(String[] args) throws Exception {


//        Integer[] arr = new Integer[]{5, 1, 6}; // ->  OK: 4
//        Integer[] arr = new Integer[]{1, 2, 3}; //-> OK: 4
//        Integer[] arr = new Integer[]{-1, -5}; // -> OK: 1
        int[] arr = {-1, -3, 4, 3};//-> OK: 2
//        Integer[] arr = new Integer[]{10}; //-> OK: 11

        Arrays.sort(arr);
        List<Integer> inputList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Integer min = inputList.stream().min(Comparator.naturalOrder()).orElseThrow(() -> new Exception("Empty list"));
        //O esto es equivalente
//        Integer min2 = inputList.stream().mapToInt(i-> i).min().getAsInt();
        Integer max = inputList.stream().max(Comparator.naturalOrder()).orElseThrow(() -> new Exception("Empty list"));


        IntStream it = IntStream.range(min, max + 1);
        List<Integer> fullRange = it.boxed().collect(Collectors.toList());
        fullRange.removeAll(inputList);
        //If list is empty means the inputList covered a full range, no gaps, so the max is outside input list...
        Integer result = fullRange.isEmpty() ? max + 1 : fullRange.stream().max(Comparator.naturalOrder()).orElse(1);

        System.out.println("The result is: " + result);
    }


}
