package com.example.basicjava.DesignPattern.book.chapter_09observer.practice.after;

public class Battery extends Subject {

    private int level = 100;

//기존의 직접적으로 연관된 관계를 끊어냄
//    private BatteryLevelDisplay display;
//    private LowBatteryWarning warning;

//    public void setDisplay(BatteryLevelDisplay display) {
//        this.display = display;
//    }
//
//    public void setWarning(LowBatteryWarning warning) {
//        this.warning = warning;
//    }

    public void consume(int amount) {
        level -= amount;
        notifyObserver();
//        display.update(); //통지
//        warning.update(); //통지
    }

    public int getLevel() {
        return level;
    }
}
