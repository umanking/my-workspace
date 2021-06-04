package com.example.basicjava.DesignPattern.book.chapter_09observer.practice2;

public class Client {

    public static void main(String[] args) {

        ElevatorController elevatorController = new ElevatorController();

        EObserver elevatorDisplay = new ElevatorDisplay(elevatorController);
        EObserver voiceNotice = new VoiceNotice(elevatorController);
        EObserver floorDisplay = new FloorDisplay(elevatorController);
        EObserver controlRoomDisplay = new ControlRoomDisplay(elevatorController);

        elevatorController.attach(elevatorDisplay);
        elevatorController.attach(voiceNotice);
        elevatorController.attach(floorDisplay);
        elevatorController.attach(controlRoomDisplay);

        elevatorController.gotoFloor(5);
        elevatorController.gotoFloor(10);

    }

}
