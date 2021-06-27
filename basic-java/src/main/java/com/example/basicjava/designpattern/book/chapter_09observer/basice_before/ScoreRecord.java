package com.example.basicjava.designpattern.book.chapter_09observer.basice_before;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecord {

    private List<Integer> scores = new ArrayList<>();
    private DataSheetView dataSheetView;

    public void setDataSheetView(DataSheetView dataSheetView) {
        this.dataSheetView = dataSheetView;
    }

    public void addScore(int score) {
        scores.add(score);
        dataSheetView.update();
    }

    public List<Integer> getScoresRecord() {
        return scores;
    }
}
