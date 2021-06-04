package com.example.basicjava.DesignPattern.book.chapter_09observer.basic_after;

public class Client {

    public static void main(String[] args) {
        ScoreRecord scoreRecord = new ScoreRecord();

        Observer dataSheetView5 = new DataSheetView(scoreRecord, 5);
        MinMaxDataView minMaxDataView = new MinMaxDataView(scoreRecord);

//        scoreRecord.setDataSheetView(dataSheetView);
        scoreRecord.attach(dataSheetView5);
        scoreRecord.attach(minMaxDataView);

        for (int index = 1; index <= 5; index++) {
            int score = index * 10;
            System.out.println("adding: " + score);
            scoreRecord.addScore(score);
            System.out.println("=======");
        }
    }

}
