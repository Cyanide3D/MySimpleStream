package ru.simple;

        import java.util.List;

public class SimpleStream {

    public static <E> SimpleVarStream<E> of(E... var) {
        return new SimpleVarStream<>(context -> {
            for (E e : List.of(var)) {
                context.execute(e);
            }
        });
    }

}
