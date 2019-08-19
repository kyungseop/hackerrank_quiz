package com.study.interview.warmup;

import com.study.quiz.Quiz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 짝이 있는 양말 수 찾기
 */
public class SockMerchant extends Quiz {

    /**
     * @param n  the number of socks in the pile
     * @param ar the colors of each sock
     * @return
     */
    static int sockMerchant(int n, int[] ar) {
        int pair = 0;

        Set<Integer> memo = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int sock = ar[i];
            if (!memo.contains(ar[i])) {
                memo.add(sock);
            } else {
                pair++;
                memo.remove(sock);
            }
        }
        return pair;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = getBufferedWriter();

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
