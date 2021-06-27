package com.example.basicjava.designpattern.book.chapter_09observer.practice2;

public class FloorDisplay implements EObserver {

    private final ElevatorController elevatorController;

    public FloorDisplay(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    @Override
    public void update() {
        int curFloor = elevatorController.getCurFloor();
        System.out.println("[outside] current flow" + curFloor);

    }
}
