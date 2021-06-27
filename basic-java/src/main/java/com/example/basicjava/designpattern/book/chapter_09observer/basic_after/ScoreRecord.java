package com.example.basicjava.designpattern.book.chapter_09observer.basic_after;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecord extends Subject {

    private List<Integer> scores = new ArrayList<>();
//    private DataSheetView dataSheetView;

//    public void setDataSheetView(DataSheetView dataSheetView) {
//        this.dataSheetView = dataSheetView;
//    }

    public void addScore(int score) {
        scores.add(score);
//        dataSheetView.update();
        notifyObservers(); // 등록된 Observer 에 통지함
    }

    public List<Integer> getScoresRecord() {
        return scores;
    }
}
