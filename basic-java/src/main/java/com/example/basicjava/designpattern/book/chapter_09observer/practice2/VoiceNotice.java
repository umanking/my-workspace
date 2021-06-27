package com.example.basicjava.designpattern.book.chapter_09observer.practice2;

public class VoiceNotice implements EObserver {

    private final ElevatorController elevatorController;

    public VoiceNotice(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    @Override
    public void update() {
        int curFloor = elevatorController.getCurFloor();
        System.out.println("[inside] voice, current floor " + curFloor);

    }
}
