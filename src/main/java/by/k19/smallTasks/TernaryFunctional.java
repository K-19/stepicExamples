package by.k19.smallTasks;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TernaryFunctional {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 5, 2, 6, 3, 6, 2, 5, 4, 3);
        List<Integer> dist = list.stream().distinct().collect(Collectors.toList());
        System.out.println(dist);
    }
}
