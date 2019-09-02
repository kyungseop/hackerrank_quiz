package com.study.interview.arrays;

import com.study.quiz.Quiz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class MinimumSwaps2 extends Quiz {

    /**
     * 중복없이 정렬되지 않은 숫자로 된 배열을 오름차순으로 정렬하기 위한 최소 swap 수 계산
     * <p>
     * i   arr                     swap (indices)
     * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
     * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
     * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
     * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
     * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
     * 5   [1, 2, 3, 4, 5, 6, 7]
     * <p>
     * it took  5 swaps to sort the array.
     *
     * @param arr unordered array
     * @return
     */
    static int minimumSwaps(int[] arr) {
        int swapCnt = 0;

        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] - 1 != idx) {
                for (int n = idx; n < arr.length; n++) {
                    if (arr[n] - 1 == idx) {
                        int tmp = arr[n];
                        arr[n] = arr[idx];
                        arr[idx] = tmp;
                        swapCnt++;
                        break;
                    }
                }
            }
        }
        return swapCnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = getBufferedWriter();
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    private static List<int[]> getTestCase() {
        List<int[]> list = new ArrayList<>();
        list.add(case1);
        list.add(case2);
        list.add(case3);
        return list;
    }

    private static int[] case1 = {2, 3, 4, 1, 5}; //3
    private static int[] case2 = {1, 3, 5, 2, 4, 6, 7}; //3
    private static int[] case3 = {4, 3, 1, 2}; //3
}
