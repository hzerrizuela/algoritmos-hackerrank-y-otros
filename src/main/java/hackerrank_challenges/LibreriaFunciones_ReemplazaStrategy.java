package hackerrank_challenges;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LibreriaFunciones_ReemplazaStrategy {

    public static class FunctionUtils {
        public static Predicate<Integer> esPar = n -> n % 2 == 0;

        public static Predicate<Integer> esImpar = n -> n % 2 != 0;

        public static Predicate<Integer> esMayoraDiez = n -> n > 10;

    }

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 10, 11, 12);
        lista.stream().filter(FunctionUtils.esMayoraDiez.and(FunctionUtils.esImpar)).forEach(System.out::println);

    }

}
