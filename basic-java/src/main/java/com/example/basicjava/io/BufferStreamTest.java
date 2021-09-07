package com.example.basicjava.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferStreamTest {

    public static void main(String[] args) {
        int count = 0;
        long millisec = 0;
        try (FileInputStream fis = new FileInputStream("a.txt");
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream("b.txt");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {

            int i;
            millisec = System.currentTimeMillis();
            while ((i = bis.read()) != -1) {
                bos.write(i);
                count++;
            }
            millisec = System.currentTimeMillis() - millisec;

            System.out.println("millisec = " + millisec);
            System.out.println("count = " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
