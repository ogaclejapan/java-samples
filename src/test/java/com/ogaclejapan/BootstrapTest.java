package com.ogaclejapan;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BootstrapTest {

    @Test
    public void test() {
        assertThat("hello", is("hello"));
    }

}
