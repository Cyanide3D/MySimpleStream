package ru.simple.collectors;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class MyCollectorImpl<R, E> implements MyCollector<R, E> {

    private final Supplier<R> supplier;
    private final BiConsumer<R, E> consumer;

    public MyCollectorImpl(Supplier<R> supplier, BiConsumer<R, E> consumer) {
        this.supplier = supplier;
        this.consumer = consumer;
    }

    @Override
    public Supplier<R> getSupplier() {
        return supplier;
    }

    @Override
    public BiConsumer<R, E> getConsumer() {
        return consumer;
    }

}
