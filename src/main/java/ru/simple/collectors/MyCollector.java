package ru.simple.collectors;

import java.util.function.BiConsumer;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public interface MyCollector<R, E, W> {

    Supplier<R> getSupplier();
    BiConsumer<R, E> getAccumulator();
    BinaryOperator<R> getCombiner();
    Function<R, W> getFinisher();

}
