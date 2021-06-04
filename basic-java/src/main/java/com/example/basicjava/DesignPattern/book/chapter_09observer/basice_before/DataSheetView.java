package com.example.basicjava.DesignPattern.book.chapter_09observer.basice_before;

import java.util.List;

// 통지 대상이 됨 > Observer 구현
public class DataSheetView {

    private ScoreRecord scoreRecord;
    private int viewCount;

    public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    // 점수 변경을 통보 받음
    public void update() {
        List<Integer> record = scoreRecord.getScoresRecord();
        displayScores(record, viewCount);
    }

    private void displayScores(List<Integer> record, int viewCount) {
        for (int i = 0; i < viewCount && i < record.size(); i++) {
            System.out.print(record.get(i) + " ");
        }
        System.out.println();

    }
}
