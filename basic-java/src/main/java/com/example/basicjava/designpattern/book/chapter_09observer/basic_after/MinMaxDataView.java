package com.example.basicjava.designpattern.book.chapter_09observer.basic_after;

import java.util.Collections;
import java.util.List;

// 통지 대상이됨 > Observer 구현
public class MinMaxDataView implements Observer {

    private ScoreRecord scoreRecord;

    public MinMaxDataView(ScoreRecord scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    // 점수 변경을 통보 받음
    public void update() {
        List<Integer> record = scoreRecord.getScoresRecord();
        displayMinMax(record);  // 최소값 최대값을 출력함

    }

    private void displayMinMax(List<Integer> record) {
        Integer min = Collections.min(record, null);
        Integer max = Collections.max(record, null);

        System.out.println("min: " + min + ", max:" + max);
    }
}
