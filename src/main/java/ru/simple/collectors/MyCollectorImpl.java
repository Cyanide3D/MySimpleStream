package ru.simple.collectors;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyCollectorImpl<R, E, W> implements MyCollector<R, E, W> {

    private final Supplier<R> supplier;
    private final BiConsumer<R, E> accumulator;
    private final BinaryOperator<R> combiner;
    private final Function<R, W> finisher;

    public MyCollectorImpl(Supplier<R> supplier, BiConsumer<R, E> accumulator, BinaryOperator<R> combiner, Function<R, W> finisher) {
        this.supplier = supplier;
        this.accumulator = accumulator;
        this.combiner = combiner;
        this.finisher = finisher;
    }

    @Override
    public Supplier<R> getSupplier() {
        return supplier;
    }

    @Override
    public BiConsumer<R, E> getAccumulator() {
        return accumulator;
    }

    @Override
    public BinaryOperator<R> getCombiner() {
        return combiner;
    }

    @Override
    public Function<R, W> getFinisher() {
        return finisher;
    }
}
