package com.example.basicjava.DesignPattern.book.chapter_09observer.practice.before;

public class BatteryLevelDisplay {

    private Battery battery;

    public BatteryLevelDisplay(Battery battery) {
        this.battery = battery;
    }

    public void update() {
        int level = battery.getLevel();
        System.out.println("level :" + level);
    }
}
