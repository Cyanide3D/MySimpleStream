package ru.simple;

import ru.simple.collectors.MyCollectors;

public class Main {

    public static void main(String[] args) {
        final SimpleVarStream<String> stream = SimpleStream.of("123", "3232", "123");

        final String qwe = stream.filter(e -> e.equalsIgnoreCase("123"))
                .union("222", "11")
                .collect(MyCollectors.joining());

        System.out.println(qwe);
    }

}
