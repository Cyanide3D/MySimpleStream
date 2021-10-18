package ru.simple;

import java.util.List;

public interface Executor<E> {

    void execute(ExecutorContext<E> context);

}
