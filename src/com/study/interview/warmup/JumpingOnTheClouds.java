package com.study.interview.warmup;

import com.study.quiz.Quiz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * "0" if they are safe or "1" if they must be avoided
 * <p>
 * 주어진 배열에서 1 을 피해 종단까지 가는데 가장짧은 경우의 수 구하기
 * 1~2칸 씩 이동가능
 *
 * <p>
 * Sample Input 0
 * 6
 * 0 0 0 0 1 0
 * <p>
 * Sample Output 0
 * 3
 * <p>
 * 설명:
 * 총 6개의 배열생성 후 해당 배열에는 0 0 0 0 1 0 값이 입력됨
 * 배열의 인덱스 0번째 부터 5번째 까지 이동하는 횟수가 가장장은 것은 3
 * <p>
 * 0-1, 1-2, 2-3, 3-5
 * 0-2, 2-3, 3-5
 */
public class JumpingOnTheClouds extends Quiz {

    /**
     * @param c an array of binary integers
     * @return Print the minimum number of jumps needed to win the game.
     */
    static int jumpingOnClouds(int[] c) {

        int maxIdx = c.length - 1;
        int jumpCnt = 0;
        int nextIdx = 0;

        for (int currentIdx = 0; currentIdx < c.length; currentIdx++) {
            if (nextIdx != currentIdx) continue;
            if (currentIdx == maxIdx) break;

            if (currentIdx == (maxIdx - 1)) {
                nextIdx = currentIdx + 1;
            } else {
                if (isCloud(c[currentIdx + 2])) {
                    nextIdx = currentIdx + 2;
                } else {
                    nextIdx = currentIdx + 1;
                }
            }
            jumpCnt++;
        }
        return jumpCnt;
    }

    private static boolean isCloud(int idxValue) {
        return idxValue == 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = getBufferedWriter();

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
