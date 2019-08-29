package com.study.interview.arrays;

import com.study.quiz.Quiz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 주어진 숫자만큼 왼쪽으로 이동
 * <p>
 * ex)
 * 배열: 1 2 3 4 5
 * 왼쪽으로 이동할 칸: 4 일 경우
 * <p>
 * 1 2 3 4 5 -> 5 1 2 3 4
 * <p>
 * <p>
 * 왼쪽으로 이동할 칸: 3 일 경우
 * <p>
 * 1 2 3 4 5 -> 4 5 1 2 3
 */
public class LeftRotation extends Quiz {
    /**
     * @param a 주어진 배열
     * @param d 왼쪽으로 이동할 수
     * @return
     */
    static int[] rotLeft(int[] a, int d) {

        int[] front = slice(a, d, a.length);
        int[] back = slice(a, 0, d);

        return IntStream.concat(Arrays.stream(front), Arrays.stream(back))
                .toArray();
    }

    private static int[] slice(int[] array, int from, int to) {
        int[] slice = new int[to - from];

        for (int i = 0; i < slice.length; i++) {
            if (from < to) {
                slice[i] = array[from++];
            }
        }
        return slice;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = getBufferedWriter();

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
