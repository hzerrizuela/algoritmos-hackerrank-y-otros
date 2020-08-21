package mi.pack;

import java.util.List;
import java.util.Map;

/**
 * Algoritmo para formar, dada una lista de enteros(L1), una nueva lista (L2) donde cada posición contenga el producto
 * de todos los elementos restantes de L1, excepto el de la posicion actual.
 * Ejemplo : L1 = [1,2,3,4]
 * > L2 = [2*3*4, 1*3*4, 1*2*4, 1*2*3] => [24, 12, 8, 6]
 */
public class MultiplicationList {

    public void fillMap(List<Integer> list, Map<Integer, List<Integer>> map) {
        if (list.isEmpty()) {
            return;
        }
        int key = list.get(0);
        List<Integer> value = tail(list);
        map.put(key, value);
        fillMap(value, map);
    }

    private List<Integer> tail(List<Integer> list) {
        List<Integer> list2 = list.subList(1, list.size());
        return list2;
    }
}
