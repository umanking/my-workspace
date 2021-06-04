package com.example.basicjava.DesignPattern.book.chapter_09observer.basic_after;

import java.util.ArrayList;
import java.util.List;

// 성적 변경에 관심이 있는 대상 객체를 관리하는 기능을 구현하는 Subject 클래스
public abstract class Subject {

    List<Observer> observerList = new ArrayList<>();

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

}
