package entrevista.despegar.parse.json.wikipedia;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuscarImparesEnRango {
    // Complete the findNumber function below.
    static List<Integer> oddNumbers(int l, int r) {
        return IntStream.range(l, r + 1).boxed().filter(n-> n % 2 != 0).collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        List<Integer> integers = oddNumbers(1, 15);
        integers.forEach(System.out::println);
    }
}