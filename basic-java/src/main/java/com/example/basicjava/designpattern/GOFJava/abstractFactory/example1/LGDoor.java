package com.example.basicjava.designpattern.GOFJava.abstractFactory.example1;

/**
 * @author Geonguk Han
 * @since 2020-09-02
 */
public class LGDoor extends Door{
    @Override
    protected void doClose() {
        System.out.println("close LG Door");
    }

    @Override
    protected void doOpen() {
        System.out.println("open LG Door");
    }
}
