package ru.simple.collectors;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public interface MyCollector<R, E> {

    Supplier<R> getSupplier();
    BiConsumer<R, E> getConsumer();

}
