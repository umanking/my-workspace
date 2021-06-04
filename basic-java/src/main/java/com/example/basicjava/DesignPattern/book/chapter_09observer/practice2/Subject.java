package com.example.basicjava.DesignPattern.book.chapter_09observer.practice2;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    List<EObserver> observerList = new ArrayList<>();


    public void attach(EObserver observer) {
        observerList.add(observer);

    }

    public void detach(EObserver observer) {
        observerList.remove(observer);
    }

    public void notifyObservers() {
        for (EObserver eObserver : observerList) {
            eObserver.update();
        }
    }


}
