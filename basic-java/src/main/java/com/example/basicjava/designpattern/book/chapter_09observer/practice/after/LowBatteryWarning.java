package com.example.basicjava.designpattern.book.chapter_09observer.practice.after;

public class LowBatteryWarning implements BObserver {

    private static final int LOW_BATTERY = 30;
    private Battery battery;

    public LowBatteryWarning(Battery battery) {
        this.battery = battery;
    }

    public void update() {
        int level = battery.getLevel();
        if (level < LOW_BATTERY) {
            System.out.println("<warning> low battery : " + level + ", Compared with " + LOW_BATTERY);
        }
    }
}
