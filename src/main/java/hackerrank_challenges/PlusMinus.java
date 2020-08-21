package hackerrank_challenges;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of integers, calculate the fractions of its elements that are positive, negative, and are zeros.
 * Print the decimal value of each fraction on a new line.
 */
public class PlusMinus {

    public static void main(String[] args) {
        int arr[] = {-4, 3, -9, 0, 4, 1};
        plusMinus(arr);
    }

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        if (arr.length == 0) return;

        Map<Boolean, List<Integer>> map = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(n -> n > 0));
        List<Integer> positiveNumbers = map.get(true);
        List<Integer> negativeNumbers = map.get(false).stream().filter(n -> n < 0).collect(Collectors.toList());
        List<Integer> zeroNumbers = map.get(false).stream().filter(n -> n == 0).collect(Collectors.toList());

        BigDecimal bigPositives = new BigDecimal((double) positiveNumbers.size() / arr.length).setScale(6, BigDecimal.ROUND_HALF_UP);
        BigDecimal bigNegatives = new BigDecimal((double) negativeNumbers.size() / arr.length).setScale(6, BigDecimal.ROUND_HALF_UP);
        BigDecimal bigZeros = new BigDecimal((double) zeroNumbers.size() / arr.length).setScale(6, BigDecimal.ROUND_HALF_UP);

        System.out.println(bigPositives);
        System.out.println(bigNegatives);
        System.out.println(bigZeros);
    }

}
