package com.example.basicwebflux.tobyReativeStream;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Geonguk Han
 * @since 2020-09-14
 */

/**
 * duality 에릭마이어 참고하기
 * Iterator - pull (iter.hasNext())
 * Observable - push (notifyObservers)
 *
 *
 *
 * 문제점 1. complete 완료된거를 확인할 길이없다.
 * 문제점 2. error 처리
 *
 */
public class ObservablePattern {

    // publisher, source
    static class IntObservable extends Observable implements Runnable{
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                setChanged();
                notifyObservers(i); // push, 브로드캐스팅을 할 수 있따!!!!!!!!!!!
            }
        }
    }
    public static void main(String[] args) {

        // subscriber
        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("Thread : " + Thread.currentThread().getName() + ", " + arg);
            }
        };


        IntObservable intObservable = new IntObservable();
        intObservable.addObserver(observer);

        // 방법1
//        intObservable.run();


        // 방법2 - 다른스레드에게 일을 시키고, main 스레드는 다른일 처리하는 방법
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(intObservable);
        executorService.shutdownNow();

    }
}
