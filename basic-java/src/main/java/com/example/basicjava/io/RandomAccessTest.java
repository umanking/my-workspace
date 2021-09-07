package com.example.basicjava.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {

    /**
     * 보통은 I/O를 InputStream, OutputStream 각각 읽기와 쓰기를 따로 하는데,
     * RandomAccesssFile은 IO를 둘다 할수있고, Disk를 읽을때처럼, file pointer가 존재해서, 위치를 알수 있다.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        RandomAccessFile rw = new RandomAccessFile("random.txt", "rw");
        rw.writeInt(100); //4byte
        System.out.println(rw.getFilePointer());
        rw.writeDouble(3.14); //8byte
        System.out.println(rw.getFilePointer());
        rw.writeUTF("안녕하세요");// 3byte * 5 + 2byte
        System.out.println(rw.getFilePointer());

        rw.seek(0);

        int i = rw.readInt();
        System.out.println("i = " + i);

        double aDouble = rw.readDouble();
        System.out.println("aDouble = " + aDouble);

        String s = rw.readUTF();
        System.out.println("s = " + s);

    }

}
