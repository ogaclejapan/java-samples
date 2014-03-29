package com.ogaclejapan;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class CollectionsTest {

    List<Person> people;

    @Before
    public void setUp() throws Exception {

        people = Arrays.asList(
                new Person("sato", 23),
                new Person("suzuki", 30),
                new Person("aoki", 20),
                new Person("watanabe", 20));

    }

    @Test
    public void testSorted() throws Exception {

        people.stream().sorted(comparing(p -> p.getAge())).forEach(System.out::println);

    }

    @Test
    public void testMap() throws Exception {

        List<String> names = people.stream().map(p -> p.getName()).collect(toList());
        System.out.println(names);

    }

    @Test
    public void testFlatMap() throws Exception {

        people.stream().flatMap(p -> Arrays.stream(
                new String[]{p.getName(), String.valueOf(p.getAge())})).forEach(System.out::println);

    }

    @Test
    public void testGroupBy() throws Exception {

        Map<Integer, List<String>> peopleByAge = people.stream().collect(
                groupingBy(p -> p.getAge(), mapping((Person p) -> p.getName(), toList())));

        System.out.println(peopleByAge);

    }

    @Test
    public void testFilter() throws Exception {

        people.stream().filter(p -> p.getAge() > 22).forEach(System.out::println);

    }

    @Test
    public void testLimit() throws Exception {

        people.stream().limit(2).forEach(System.out::println);

    }

    @Test
    public void testSkip() throws Exception {

        people.stream().skip(2).forEach(System.out::println);

    }

    @Test
    public void testDistinct() throws Exception {

        people.stream().map(Person::getAge).distinct().forEach(System.out::println);

    }

    @Test
    public void testAllMatch() throws Exception {

        if (people.stream().allMatch(p -> p.getAge() > 19)) {
            System.out.println("all adult");
        }

    }

    @Test
    public void testAnyMatch() throws Exception {

        if (people.stream().anyMatch(p -> p.getAge() >= 30)) {
            System.out.println("found around the age of 30");
        }

    }
}
