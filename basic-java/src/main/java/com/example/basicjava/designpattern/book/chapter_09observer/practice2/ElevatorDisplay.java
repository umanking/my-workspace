package com.example.basicjava.designpattern.book.chapter_09observer.practice2;

public class ElevatorDisplay implements EObserver{

    private final ElevatorController elevatorController;

    public ElevatorDisplay(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    @Override
    public void update() {
        int curFloor = elevatorController.getCurFloor();
        System.out.println("[inside] current flow " + curFloor);

    }
}
