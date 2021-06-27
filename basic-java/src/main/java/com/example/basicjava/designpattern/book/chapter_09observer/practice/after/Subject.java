package com.example.basicjava.designpattern.book.chapter_09observer.practice.after;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<BObserver> bObserverList = new ArrayList<>();

    public void attach(BObserver observer) {
        bObserverList.add(observer);

    }

    public void detach(BObserver observer) {
        bObserverList.remove(observer);
    }

    public void notifyObserver() {
        for (BObserver bObserver : bObserverList) {
            bObserver.update();
        }
    }

}
