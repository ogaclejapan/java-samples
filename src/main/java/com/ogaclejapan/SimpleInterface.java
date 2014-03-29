package com.ogaclejapan;

public interface SimpleInterface {

    public void doSomeWork();

    default public void doSomeOtherWork() {
        System.out.println("called interface#doSomeOtherWork.");
    }
}
