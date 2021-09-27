package by.k19.smallTasks;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class pseudoRandomStream {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> (n * n) % 10000 / 10);
    }

    public static void main(String[] args) {
        pseudoRandomStream(13).limit(20).forEach(System.out::println);
    }
}
