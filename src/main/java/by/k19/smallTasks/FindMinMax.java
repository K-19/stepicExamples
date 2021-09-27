package by.k19.smallTasks;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMinMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.collect(Collectors.toList());
        if (list.size() == 0)
            minMaxConsumer.accept(null, null);
        else {
            Collections.sort(list, order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    public static void main(String[] args) {

    }
}
