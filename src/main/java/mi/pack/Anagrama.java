package mi.pack;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

/**
 * Anagrama
 */
public class Anagrama {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        List<Character> l1 = s1.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        List<Character> l2 = s1.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        l1.sort((p1, p2) -> p1.compareTo(p2));
        l2.sort((p1, p2) -> p1.compareTo(p2));
        for (int i = 0; i < l1.size(); i++) {
           Character elem = l1.get(i);
           l2.removeIf(e -> e == elem);
        }

        return 0;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s1 = scanner.nextLine();
//
//        String s2 = scanner.nextLine();

        int result = makingAnagrams("ramos", "amor");

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }

}
