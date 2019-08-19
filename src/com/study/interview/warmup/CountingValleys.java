package com.study.interview.warmup;

import com.study.quiz.Quiz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Print a single integer that denotes the number of valleys Gary walked through during his hike.
 * <p>
 * ex)
 * 8
 * UDDDUDUU
 * <p>
 * the number of valleys : 1
 * <p>
 * 각 문자 하나에 1 칸씩 올라가거나(U) 내려간다(D).
 */
public class CountingValleys extends Quiz {

    /**
     * @param n the number of steps Gary takes
     * @param s a string describing his path (U: uphill,D:downhill)
     * @return
     */
    static int countingValleys(int n, String s) {

        int valleys = 0;

        int tmp;
        int after = 0;

        for (int i = 0; i < n; i++) {
            String path = Character.toString(s.charAt(i));
            tmp = after;
            if ("U".equalsIgnoreCase(path)) {
                after = tmp + 1;
            } else if ("D".equalsIgnoreCase(path)) {
                after = tmp - 1;
            }

            if (after == 0 && tmp == -1) {
                valleys++;
            }
        }
        return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = getBufferedWriter();

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();
        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
