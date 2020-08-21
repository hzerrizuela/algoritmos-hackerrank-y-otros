package hackerrank_challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. When she blows out the candles, she’ll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully blow out.
 * For example, if your niece is turning  years old, and the cake will have  candles of height , , , , she will be able to blow out  candles successfully, since the tallest candles are of height  and there are  such candles
 *
 * @see - https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
public class BonAppetit {


    public static void main(String[] args) {
        List<Integer> bill = Arrays.asList(3, 10, 2, 9);
        bonAppetit(bill, 1, 12);
    }

    /**
     * @param bill: an array of integers representing the cost of each item ordered
     * @param k:    an integer representing the zero-based index of the item Anna doesn't eat
     * @param b:    the amount of money that Anna contributed to the bill
     */
    static void bonAppetit(List<Integer> bill, int k, int b) {
        double totalPerson = bill.stream().mapToInt(a -> a).sum() / 2;
        Integer unwantedItem = bill.get(k);
        double diff = totalPerson - unwantedItem / 2;

        if (diff == b) {
            System.out.println("Bon Appetit");
        } else {
            int debt = (int) (totalPerson - diff);
            System.out.println(debt);
        }

    }


}
