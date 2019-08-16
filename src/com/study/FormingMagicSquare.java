package com.study;

import com.study.quiz.Quiz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

/**
 * 3x3 matrix 를 생성하기 위한 정수(1-9 사이)를 입력받는다.
 * 입력받은 matrix 를 magic matrix 로 변환하고 변환하는데 드는 총비용을 계산한다.
 * <p>
 * magic matrix 조건
 * 1. 가로, 세로, 대각선의 합이 모두 같아야함.(3x3인 경우 15가 최대값)
 * 2. matrix 내에 동일한 숫자는 없어야함.
 *
 * <p>
 * ex)
 * 5 3 4
 * 1 5 8
 * 6 4 2
 * <p>
 * 위와 같이 입력을 받고 아래와 같이 변환한다.
 * 비용계산 방법
 * 1. 변경된 숫자들 확인: 위와 아래 matrix 를 비교하면 5 -> 8, 8 -> 9, 4 -> 7로 변경됨.
 * 2. (5-8)+(8-9)+(4-7) = 7 (절대값으로 계산) 이 나오므로 총비용은 7 이 됨.(최소의 비용값을 전달해야함)
 * <p>
 * 8 3 4
 * 1 5 9
 * 6 7 2
 */
public class FormingMagicSquare extends Quiz {

    /**
     * magic square 가 되는 모든 조건 - 중간값은 5가 되어야 가로, 세로, 대각선 모두 같은 값이 나온다.
     */
    private static int[][] case1 = new int[][]{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
    private static int[][] case2 = new int[][]{{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
    private static int[][] case3 = new int[][]{{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
    private static int[][] case4 = new int[][]{{2, 9, 4}, {7, 5, 3}, {6, 1, 8}};
    private static int[][] case5 = new int[][]{{8, 3, 4}, {1, 5, 9}, {6, 7, 2}};
    private static int[][] case6 = new int[][]{{4, 3, 8}, {9, 5, 1}, {2, 7, 6}};
    private static int[][] case7 = new int[][]{{6, 7, 2}, {1, 5, 9}, {8, 3, 4}};
    private static int[][] case8 = new int[][]{{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};


    private static List<int[][]> getPreDefinedSquare() {
        List<int[][]> list = new ArrayList<>();
        list.add(case1);
        list.add(case2);
        list.add(case3);
        list.add(case4);
        list.add(case5);
        list.add(case6);
        list.add(case7);
        list.add(case8);
        return list;
    }

    static int formingMagicSquare(int[][] s) {

        List<int[][]> preDefinedSquare = getPreDefinedSquare();

        List<Integer> result = new ArrayList<>();

        preDefinedSquare.forEach(
                array -> {
                    int sum = 0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            int number = s[i][j];
                            int definedNumber = array[i][j];
                            //절대값
                            sum += Math.abs(number - definedNumber);
                        }
                    }
                    result.add(sum);

                }
        );
        return result.stream().min(Integer::compare).orElse(0);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = getBufferedWriter();

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }
        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
