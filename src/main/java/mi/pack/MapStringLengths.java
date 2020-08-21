package mi.pack;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a list of strings, return a map where key = string, value = length of that string.
 */
public class MapStringLengths {

    public static void main(String[] args) {

        List<String> listOfString = Arrays.asList("hola!", "hey", "jude");
        Map<String, Integer> stringToLength
                = listOfString
                .stream()
                .collect(
                        Collectors.toMap(Function.identity(), String::length));

        stringToLength.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));
    }
}
