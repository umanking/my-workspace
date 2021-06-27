package com.example.basicjava.designpattern.book.chapter_09observer.practice.after;

public class BatteryLevelDisplay implements BObserver {

    private Battery battery;

    public BatteryLevelDisplay(Battery battery) {
        this.battery = battery;
    }

    public void update() {
        int level = battery.getLevel();
        System.out.println("level :" + level);
    }
}
