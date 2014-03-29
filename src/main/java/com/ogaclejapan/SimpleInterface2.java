package com.ogaclejapan;

public interface SimpleInterface2 {

    public void doSomeWork();

    default public void doSomeOtherWork() {
        System.out.println("called interface2#doSomeOtherWork.");
    }

}
