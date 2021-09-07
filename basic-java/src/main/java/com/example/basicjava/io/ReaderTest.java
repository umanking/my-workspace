package com.example.basicjava.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderTest {

    public static void main(String[] args) {
        int i;
        try (Reader reader = new FileReader("input.txt")) {
            while ((i = reader.read()) != -1) {
                System.out.println((char)i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
