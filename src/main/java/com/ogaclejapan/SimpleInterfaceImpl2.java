package com.ogaclejapan;

public class SimpleInterfaceImpl2 implements SimpleInterface, SimpleInterface2 {

    @Override
    public void doSomeWork() {
        System.out.println("called impl2#doSomeWork.");
    }

    @Override
    public void doSomeOtherWork() {
        SimpleInterface2.super.doSomeOtherWork();
    }
}
