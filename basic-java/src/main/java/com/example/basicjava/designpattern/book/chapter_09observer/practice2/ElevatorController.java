package com.example.basicjava.designpattern.book.chapter_09observer.practice2;

public class ElevatorController extends Subject{

    private int curFloor = 1;


    public void gotoFloor(int destination) {
        curFloor = destination;
        notifyObservers();
    }

    public int getCurFloor() {
        return curFloor;
    }
}
