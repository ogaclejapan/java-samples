package com.ogaclejapan;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class CollectionsTest {

    static class Person {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

    }

    List<Person> people;

    @Before
    public void setUp() throws Exception {

        people = Arrays.asList(
                new Person("sato", 23),
                new Person("suzuki", 30),
                new Person("aoki", 20),
                new Person("watanabe", 20));

    }

    // 年齢の昇順にリストを並び替えて表示する
    @Test
    public void testSorted() throws Exception {

        people.stream().sorted(comparing(p -> p.getAge())).forEach(System.out::println);

    }

    // 名前だけを抽出したリストに変換して表示する
    @Test
    public void testMap() throws Exception {

        List<String> names = people.stream().map(p -> p.getName()).collect(toList());
        System.out.println(names);

    }

    // 名前と年齢を交互に格納したリストに変換して表示する
    @Test
    public void testFlatMap() throws Exception {

        people.stream().flatMap(p -> Arrays.stream(
                new String[]{p.getName(), String.valueOf(p.getAge())})).forEach(System.out::println);

    }

    // 年齢をキーにグループ化した名前リストのMap<Integer, List<String>>型に変換して表示する
    @Test
    public void testGroupBy() throws Exception {

        Map<Integer, List<String>> peopleByAge = people.stream().collect(
                groupingBy(p -> p.getAge(), mapping((Person p) -> p.getName(), toList())));

        System.out.println(peopleByAge);

    }

    // 年齢が22歳より上の人を抽出して表示する
    @Test
    public void testFilter() throws Exception {

        people.stream().filter(p -> p.getAge() > 22).forEach(System.out::println);

    }

    // リスト先頭から2名分の人を抽出して表示する
    @Test
    public void testLimit() throws Exception {

        people.stream().limit(2).forEach(System.out::println);

    }

    // リスト先頭から2名分の人を除いて表示する
    @Test
    public void testSkip() throws Exception {

        people.stream().skip(2).forEach(System.out::println);

    }

    // 年齢のリストに変換して、重複を除いた年齢を表示する
    @Test
    public void testDistinct() throws Exception {

        people.stream().map(Person::getAge).distinct().forEach(System.out::println);

    }

    // 全員の年齢が19歳より上かどうかを判定する
    @Test
    public void testAllMatch() throws Exception {

        if (people.stream().allMatch(p -> p.getAge() > 19)) {
            System.out.println("all adult");
        }

    }

    // 30歳以上の人が存在するかを判定する
    @Test
    public void testAnyMatch() throws Exception {

        if (people.stream().anyMatch(p -> p.getAge() >= 30)) {
            System.out.println("found around the age of 30");
        }

    }

}
