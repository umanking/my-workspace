package com.example.basicjava.designpattern.GOFJava.abstractFactory.example1.solution;


import com.example.basicjava.designpattern.GOFJava.abstractFactory.example1.Door;
import com.example.basicjava.designpattern.GOFJava.abstractFactory.example1.HyundaiDoor;
import com.example.basicjava.designpattern.GOFJava.abstractFactory.example1.LGMotor;
import com.example.basicjava.designpattern.GOFJava.abstractFactory.example1.Motor;

/**
 * @author Geonguk Han
 * @since 2020-09-02
 */
public class LGElevatorFactory extends ElevatorFactory {

    @Override
    public Motor createMotor() {
        return new LGMotor();
    }

    @Override
    public Door createDoor() {
        return new HyundaiDoor();
    }

}
