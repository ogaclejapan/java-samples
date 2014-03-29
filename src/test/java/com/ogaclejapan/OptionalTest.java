package com.ogaclejapan;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void testOptional1() throws Exception {

        Optional<String> name = Optional.of("foo");

        if (name.isPresent()) {
            System.out.println(name.get());
        }

        name.ifPresent(System.out::println);

        System.out.println(name.orElse("hoge"));

    }

    @Test
    public void testEmpty() throws Exception {

        Optional<String> empty = Optional.empty();

        if (empty.isPresent()) {
            System.out.println(empty.get());
        }

        System.out.println(empty.orElse("empty"));

    }

    @Test
    public void testNull() throws Exception {

        Optional<String> nil = Optional.ofNullable(null);

        if (nil.isPresent()) {
            System.out.println(nil.get());
        }

        System.out.println(nil.orElse("null"));

    }

}
