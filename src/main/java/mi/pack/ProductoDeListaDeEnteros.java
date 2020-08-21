package mi.pack;

import java.util.*;

// Algoritmo para formar, dada una lista de enteros(L1), una nueva lista (L2) donde cada posición contenga el producto
// * de todos los elementos restantes de L1, excepto el de la posicion actual.
// * Ejemplo : L1 = [1,2,3,4]
// * > L2 = [2*3*4, 1*3*4, 1*2*4, 1*2*3] => [24, 12, 8, 6]
public class ProductoDeListaDeEnteros {

    public static void main(String[] args) {
//        Integer[] numbers = new Integer[]{1, 2, 3, 4};
        Integer[] numbers = new Integer[]{8, 2, 4, 5, 0};
//        Integer[] numbers = new Integer[]{8, 2, 4, 5};

        List<Integer> initList = Arrays.asList(numbers);
        List<Integer> resultList = solution2(initList);

        System.out.println("THE END - Resulting list:: " + resultList);
    }

    private static List<Integer> solution2(List<Integer> numbers) {
        Integer product = numbers.stream().reduce(1, (a, b) -> a * b);
        List<Integer> resultList = new ArrayList<>();
        for (int n : numbers) {
            int number = (n != 0) ? product / n : -1;
            resultList.add(number);
        }
        return resultList;
    }

    private static List<Integer> solution1(List<Integer> initList) {
        List<Integer> resultList = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new LinkedHashMap<>();

        MultiplicationList productList = new MultiplicationList();
        productList.fillMap(initList, map);

        Integer oldKeys = 1;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer product = entry.getValue().stream().reduce(1, (a, b) -> a * b);
            Integer totalProduct = product * oldKeys;
            resultList.add(totalProduct);
            oldKeys = oldKeys * entry.getKey();
        }
        return resultList;
    }
}
