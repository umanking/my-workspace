package com.example.basicjava.designpattern.book.chapter_09observer.practice.after;

public class Client {

    public static void main(String[] args) {

        // 배터리 클래스, 초기 level값을 지정, levelDisplay와 Warning 클래스를 포함한다.
        Battery battery = new Battery();

        BObserver batteryLevelDisplay = new BatteryLevelDisplay(battery);
        BObserver lowBatteryWarning = new LowBatteryWarning(battery);

        battery.attach(batteryLevelDisplay);
        battery.attach(lowBatteryWarning);

        battery.consume(20);
        battery.consume(50);
        battery.consume(10);
    }

}
