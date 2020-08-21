package cracking;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    Implement an algorithm to determine if a string has all unique characters What if you
    can not use additional data structures?
*/
public class AllUnique {

    public static void main(String[] args) {
//        String str = "something";
        String str = "opss";

        List<String> listOfString = Arrays.asList("hola", "hey", "jude");
        Map<String, Integer> stringToLength
                = listOfString
                .stream()
                .collect(
                        Collectors.toMap(Function.identity(), String::length));

        System.out.println("All unique? " + allUnique(str));
    }

    /**
     * Recursive allUnique method
     *
     * @param str
     * @return
     */
    private static boolean allUnique(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String tail = str.substring(i + 1);
            if (exists(c, tail)) {
                return false;
            } else {
                allUnique(tail);
            }
        }
        //If never existed, then it's unique
        return true;
    }

    private static boolean exists(char c, String str) {
        return str.indexOf(c) != -1;
    }
}
