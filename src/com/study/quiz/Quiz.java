package com.study.quiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public abstract class Quiz {

    protected static BufferedWriter getBufferedWriter() throws IOException {
        return new BufferedWriter(new FileWriter(System.getenv("PWD") + File.separator + "output.txt"));
    }

    protected static void printArray(String type, int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                sb.append("[ ");
            }
            sb.append(array[i]);
            if (i == array.length - 1) {
                sb.append(" ]");
            } else {
                sb.append(",");
            }
        }
        System.out.println(type + " " + sb.toString());
    }

    protected static String readLineByLine(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

}
