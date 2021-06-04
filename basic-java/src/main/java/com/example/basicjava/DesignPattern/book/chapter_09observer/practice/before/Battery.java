package com.example.basicjava.DesignPattern.book.chapter_09observer.practice.before;

public class Battery {

    private int level = 100;
    private BatteryLevelDisplay display;
    private LowBatteryWarning warning;

    public void setDisplay(BatteryLevelDisplay display) {
        this.display = display;
    }

    public void setWarning(LowBatteryWarning warning) {
        this.warning = warning;
    }

    public void consume(int amount) {
        level -= amount;
        display.update(); //통지
        warning.update(); //통지
    }

    public int getLevel() {
        return level;
    }
}
