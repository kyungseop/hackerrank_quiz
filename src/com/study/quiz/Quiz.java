package com.study.quiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

}
