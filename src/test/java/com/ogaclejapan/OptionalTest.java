package com.ogaclejapan;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void testOptional() throws Exception {

        Optional<String> name = Optional.of("foo");

        if (name.isPresent()) {
            System.out.println(name.get());
        }

        name.ifPresent(System.out::println);

        System.out.println(name.orElse("hoge"));

    }

    @Test
    public void testEmpty() throws Exception {

        Optional<String> name = Optional.empty();

        if (name.isPresent()) {
            System.out.println(name.get());
        }

        System.out.println(name.orElse("empty"));

    }

    @Test
    public void testNull() throws Exception {

        Optional<String> name = Optional.ofNullable(null);

        if (name.isPresent()) {
            System.out.println(name.get());
        }

        System.out.println(name.orElse("null"));

    }

    @Test
    public void testFilter() throws Exception {

        Optional<String> name = Optional.of("foo");

        name.filter(x -> x.equals("foo")).ifPresent(System.out::println);

    }

    @Test
    public void testFilterCaseOfNull() throws Exception {

        Optional<String> name = Optional.ofNullable(null);

        name.filter(x -> x.equals("foo")).ifPresent(System.out::println);

    }

    @Test
    public void testMap() throws Exception {

        Optional<String> name = Optional.of("  foo  ");

        name.map(String::trim).filter(s -> s.length() > 0).ifPresent(System.out::println);

    }

    @Test
    public void testMapCaseOfNull() throws Exception {

        Optional<String> name = Optional.ofNullable(null);

        name.map(String::trim).filter(s -> s.length() > 0).ifPresent(System.out::println);

    }
}
