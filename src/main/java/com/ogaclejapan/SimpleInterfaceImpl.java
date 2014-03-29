package com.ogaclejapan;

public class SimpleInterfaceImpl implements SimpleInterface {

    @Override
    public void doSomeWork() {
        System.out.println("called impl#doSomeWork.");
    }
}
