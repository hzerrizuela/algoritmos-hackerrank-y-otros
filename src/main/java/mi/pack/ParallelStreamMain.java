package mi.pack;

import java.util.stream.IntStream;

/**
 * @see - https://www.arquitecturajava.com/java-parallel-stream-y-rendimiento/
 */
public class ParallelStreamMain {

    public static void main(String[] args) {

        long numero1 = System.currentTimeMillis();

        IntStream lista = IntStream.range(1, 10);
//        int total = lista.map(ParallelStreamMain::duplicar).sum();
        //En cambio, si lo hago parallel, tarda mucho menos:
        int total = lista.parallel().map(ParallelStreamMain::duplicar).sum();

        long numero2 = System.currentTimeMillis();
        System.out.println("Time elapsed: "+ (numero2 - numero1));
        System.out.println(total);

    }

    public static int duplicar(int numero) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return numero * 2;
    }

}
