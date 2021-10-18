package ru.simple;

import ru.simple.collectors.MyCollector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleVarStream<E> {

    private final Executor<E> executor;

    public SimpleVarStream(Executor<E> executor) {
        this.executor = executor;
    }

    public SimpleVarStream<E> filter(Predicate<E> predicate) {
        return new SimpleVarStream<>(context -> executor.execute(value -> {
            if (predicate.test(value)) {
                context.execute(value);
            }
        }));
    }

    public SimpleVarStream<E> union(E... var) {
        return new SimpleVarStream<>(context -> {
            executor.execute(context);
            List.of(var).forEach(context::execute);
        });
    }

    public SimpleVarStream<E> sorted(Comparator<E> comparator) {
        return new SimpleVarStream<>(context -> {
            List<E> es = new ArrayList<>();
            executor.execute(es::add);

            es.sort(comparator);
            for (E e : es) {
                context.execute(e);
            }
        });
    }

    public <R> SimpleVarStream<R> map(Function<E, R> function) {
        return new SimpleVarStream<>(context -> executor.execute(
                value -> context.execute(function.apply(value))
        ));
    }

    public void forEach(Consumer<? super E> consumer) {
        executor.execute(consumer::accept);
    }

    public <R> R collect(MyCollector<R, E> collector) {
        R col = collector.getSupplier().get();
        executor.execute(value -> collector.getConsumer().accept(col, value));

        return col;
    }

}
