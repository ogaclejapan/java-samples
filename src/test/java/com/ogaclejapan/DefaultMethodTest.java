package com.ogaclejapan;

import org.junit.Test;

public class DefaultMethodTest {

    static interface SimpleInterface {

        public void doSomeWork();

        default public void doSomeOtherWork() {
            System.out.println("called interface#doSomeOtherWork.");
        }
    }

    static interface SimpleInterface2 {

        public void doSomeWork();

        default public void doSomeOtherWork() {
            System.out.println("called interface2#doSomeOtherWork.");
        }

    }

    static class SimpleInterfaceImpl implements SimpleInterface {

        @Override
        public void doSomeWork() {
            System.out.println("called impl#doSomeWork.");
        }
    }

    static class SimpleInterfaceImpl2 implements SimpleInterface, SimpleInterface2 {

        @Override
        public void doSomeWork() {
            System.out.println("called impl2#doSomeWork.");
        }

        @Override
        public void doSomeOtherWork() {
            SimpleInterface2.super.doSomeOtherWork();
        }
    }


    @Test
    public void testSimple1() throws Exception {

        SimpleInterface simple = new SimpleInterfaceImpl();

        simple.doSomeWork();
        simple.doSomeOtherWork();

    }

    @Test
    public void testSimple2() throws Exception {

        SimpleInterface simple = new SimpleInterfaceImpl2();

        simple.doSomeWork();
        simple.doSomeOtherWork();

    }
}
