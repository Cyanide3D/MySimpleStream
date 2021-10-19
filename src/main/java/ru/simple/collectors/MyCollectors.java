package ru.simple.collectors;

import java.util.*;

public class MyCollectors {

    public static <E> MyCollector<List<E>, E, List<E>> toList() {
        return new MyCollectorImpl<>(ArrayList::new, List::add,
                (a, b) -> {a.addAll(b); return a;}, ArrayList::new);
    }

    public static <E> MyCollector<HashSet<E>, E, Set<E>> toSet() {
        return new MyCollectorImpl<>(HashSet::new, Set::add,
                (a, b) -> {a.addAll(b); return a;}, HashSet::new);
    }

//    public static MyCollector<StringBuilder, String, String> joining(String delimiter) {
//        return new MyCollectorImpl<>(StringBuilder::new, (o, v) -> o.append(v).append(delimiter),
//                (a, b) -> {a.append(b); return a;}, StringBuilder::toString);
//    }

    public static MyCollector<StringJoiner, String, String> joining(String delimiter) {
        return new MyCollectorImpl<>(() -> new StringJoiner(delimiter), StringJoiner::add,
                StringJoiner::merge, StringJoiner::toString);
    }

    public static MyCollector<StringJoiner, String, String> joining() {
        return joining("");
    }


}
