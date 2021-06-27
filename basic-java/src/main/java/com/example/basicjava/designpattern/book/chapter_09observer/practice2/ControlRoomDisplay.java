package com.example.basicjava.designpattern.book.chapter_09observer.practice2;

public class ControlRoomDisplay implements EObserver {

    private final ElevatorController elevatorController;

    public ControlRoomDisplay(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    @Override
    public void update() {
        int curFloor = elevatorController.getCurFloor();
        System.out.println("[outside] room display, current floor " + curFloor);

    }
}
