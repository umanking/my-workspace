package com.example.basicjava.designpattern.GOFJava.abstractFactory.example1.solution;


import com.example.basicjava.designpattern.GOFJava.abstractFactory.example1.Door;
import com.example.basicjava.designpattern.GOFJava.abstractFactory.example1.Motor;

/**
 * @author Geonguk Han
 * @since 2020-09-02
 */
public abstract class ElevatorFactory {

    public abstract Motor createMotor();

    public abstract Door createDoor();
}
