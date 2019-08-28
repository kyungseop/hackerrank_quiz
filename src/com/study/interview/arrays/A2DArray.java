package com.study.interview.arrays;

import com.study.quiz.Quiz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 2DArray
 * <p>
 * 숫자가 총합이 가장 큰 모래시계(hourglass) 찾기
 * <p>
 * 6 x 6 으로 된 array 가 있으며 아래와 같은 모레시계 패턴으로 숫자롤 합하여 가장 큰 수를 찾는다. 총 16개
 * <p>
 * 모래시계 패턴
 * <p>
 * a b c
 *   d
 * e f g
 * <p>
 * Sample Input
 * <p>
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * <p>
 * <p>
 * Sample Output
 * <p>
 * 19
 * <p>
 * <p>
 * 설명: Sample Input 에서 16의 모레시계 확인방법 (배열 인덱스로 표시)
 * 첫번째: [0,0] [0,1] [0,2] [1,1] [3,0] [3,1] [3,2]
 * 두번째: [0,1] [0,2] [0,3] [1,2] [3,1] [3,2] [3,3]
 * 세번째: [0,2] [0,3] [0,4] [1,3] [3,2] [3,3] [3,4]
 * 네번째: [0,3] [0,4] [0,5] [1,4] [3,3] [3,4] [3,5]
 * .... 위와 같은 방식으로 우로 한칸, 아래로 한칸씩 이동하며 모레시계형태롤 총 16개 만들수 있다.
 * <p>
 * 2 4 4
 *   2
 * 1 2 4
 */
public class A2DArray extends Quiz {

    static int hourglassSum(int[][] arr) {

        int maxSum = Integer.MIN_VALUE;

        for (int y = 0; y < 4; y++) {
            // 세로
            for (int x = 0; x < 4; x++) {
                //가로
                int sumNumber = sumNumber(arr, y, x);
                if (maxSum < sumNumber) {
                    maxSum = sumNumber;
                }
            }
        }
        return maxSum;
    }

    /**
     * 가로, 세로 0 - 3 번 인덱스 까지만 첫번째로 올 수 있음 , 가운데 값은 본인기준 세로 -1, 가로 +1
     *
     * @param arr 입력값
     * @param y   y축 인덱스
     * @param x   x축 인덱스
     * @return  모레시계패턴 값의 합
     */
    private static int sumNumber(int[][] arr, int y, int x) {
        int topFirst = arr[y][x];
        int topSecond = arr[y][x + 1];
        int topThird = arr[y][x + 2];
        int mid = arr[y + 1][x + 1];
        int bottomFirst = arr[y + 2][x];
        int bottomSecond = arr[y + 2][x + 1];
        int bottomThird = arr[y + 2][x + 2];
        return topFirst + topSecond + topThird + mid + bottomFirst + bottomSecond + bottomThird;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = getBufferedWriter();
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static int[][] getSampleArray() {
        return new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
    }

    static int[][] getSampleArray2() {
        return new int[][]{
                {-9, -9, -9, -1, -1, -1},
                {0, -9, 0, -4, -3, -2},
                {-9, -9, -9, -1, -2, -3},
                {0, 0, -8, -9, -9, -9},
                {0, 0, 0, -2, -9, 0},
                {0, 0, -1, -9, -9, -9}
        };
    }

    static int[][] getSampleArray3() {
        return new int[][]{
                {-1, 1, -1, 0, 0, 0},
                {0, -1, 0, 0, 0, 0},
                {-1, -1, -1, 0, 0, 0},
                {0, -9, 2, -4, -4, 0},
                {-7, 0, 0, -2, 0, 0},
                {0, 0, -1, -2, -4, 0}
        };
    }

}
