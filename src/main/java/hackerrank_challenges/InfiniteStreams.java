package hackerrank_challenges;

import java.util.Arrays;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @see https://www.baeldung.com/java-inifinite-streams
 */
public class InfiniteStreams {

    public static void main(String[] args) throws Exception {
        Supplier<UUID> randomUUIDSuppllier = UUID::randomUUID;

        Stream<UUID> infiniteStreamofRandomUUID = Stream.generate(randomUUIDSuppllier);

        List<UUID> randomInts = infiniteStreamofRandomUUID.skip(10).limit(10).collect(Collectors.toList());

        randomInts.forEach(System.out::println);

        Stream<Integer> integers = Stream
                .iterate(0, i -> i + 1);
        integers
                .limit(10)
                .forEach(System.out::println);

    }


}
