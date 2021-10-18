package ru.simple.collectors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyCollectors {

    public static <E> MyCollector<List<E>, E> toList() {
        return new MyCollectorImpl<>(ArrayList::new, List::add);
    }

    public static <E> MyCollector<HashSet<E>, E> toSet() {
        return new MyCollectorImpl<>(HashSet::new, Set::add);
    }

    public static <E> MyCollector<String, E> joining(String delimiter) {
        return new MyCollectorImpl<>(String::new, (o, v) -> {});
    }


}
