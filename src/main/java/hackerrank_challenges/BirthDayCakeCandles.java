package hackerrank_challenges;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age.
 * When she blows out the candles, she’ll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully
 * blow out.
 * For example, if your niece is turning 4 years old, and the cake will have 4 candles of height 4, 4, 1, 3,
 * she will be able to blow out 2 candles successfully, since the tallest candles are of height 4  and there are 2 such candles
 *
 * @see - https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
public class BirthDayCakeCandles {


    public static void main(String[] args) {
        int[] candles = new int[]{3, 2, 1, 3};
        System.out.println("Answer is: " + birthdayCakeCandles(candles));
    }

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        if (ar.length == 0) {
            return 0;
        }
        List<Integer> list = Arrays.stream(ar).boxed().collect(Collectors.toList());
        int maxim = list.stream().mapToInt(a -> a).max().getAsInt();
        return  Collections.frequency(list, maxim); //o tambien: (int) list.stream().filter(i -> i == maxim).count();


    }


}
