package com.ogaclejapan;

import org.junit.Test;

public class DefaultMethodTest {


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
