package com.example.basicjava.DesignPattern.book.chapter_09observer.practice.before;

public class Client {

    public static void main(String[] args) {

        // 배터리 클래스, 초기 level값을 지정, levelDisplay와 Warning 클래스를 포함한다.
        Battery battery = new Battery();

        BatteryLevelDisplay batteryLevelDisplay = new BatteryLevelDisplay(battery);
        LowBatteryWarning lowBatteryWarning = new LowBatteryWarning(battery);

        battery.setDisplay(batteryLevelDisplay);
        battery.setWarning(lowBatteryWarning);

        battery.consume(20);
        battery.consume(50);
        battery.consume(10);
    }

}
