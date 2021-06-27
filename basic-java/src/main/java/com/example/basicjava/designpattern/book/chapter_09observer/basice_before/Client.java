package com.example.basicjava.designpattern.book.chapter_09observer.basice_before;

public class Client {

    public static void main(String[] args) {
        ScoreRecord scoreRecord = new ScoreRecord();

        DataSheetView dataSheetView = new DataSheetView(scoreRecord, 5);
        scoreRecord.setDataSheetView(dataSheetView);

        for (int index = 1; index <= 5; index++) {
            int score = index * 10;
            System.out.println("adding: " + score);
            scoreRecord.addScore(score);
            System.out.println("=======");
        }
    }

}
