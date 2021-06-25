package com.example.basicjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FileTest {

    @Test
    void 디렉토리만들기() {
        File directory = new File("test/test");
        if (!directory.exists()) {
            boolean mkdir = directory.mkdirs();
            log.info("mkdir = {}", mkdir);
        } else {
            log.info("Already exist directory");
        }
    }

    @Test
    void 파일쓰기() throws IOException {
        File file = new File("example.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        bufferedWriter.write("hello\nworld");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    @Test
    void 파일쓰기_없는경로() throws IOException {
        // 없는 경로를 넘겨주면 안된다.
        File file = new File("test/test/example.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        bufferedWriter.write("hello\nworld");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    @Test
    void 파일읽기() throws IOException {
        File file = new File("example.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String data = bufferedReader.lines().collect(Collectors.joining("\n"));

        System.out.println(data);

    }

    @Test
    void java_nio_test() throws IOException {
        Path path = Paths.get("example.txt");
        // jdk 1.7, java nio pacakge
        // Files.readAllLines  (small file)
        List<String> list = Files.readAllLines(path);
        String collect = list.stream().collect(Collectors.joining(System.lineSeparator()));
        System.out.println(collect);
        System.out.println("=======");

        // Files.newBufferedReader (large file)
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        StringBuilder builder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            builder.append(line);
            builder.append(System.lineSeparator());
            line = bufferedReader.readLine();
        }
        String result = builder.toString();
        System.out.println(result);
        System.out.println("=======");

        // jdk 1.8 Files.lines()
        String result1 = Files.lines(path).collect(Collectors.joining(System.lineSeparator()));
        System.out.println(result1);
    }
}
