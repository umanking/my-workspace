package com.example.basicjava.io;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamTest {

    public static void main(String[] args) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("input.txt")) {
            int i = 0;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
