package com.study;

import java.math.BigInteger;
import java.util.Scanner;

public class MiniMaxSum {


    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        //long 변환도 가능
        int initNumber = arr[0];
        BigInteger min = BigInteger.valueOf(initNumber);
        BigInteger max = BigInteger.valueOf(initNumber);
        BigInteger sum = BigInteger.valueOf(initNumber);

        for (int i = 1; i < arr.length; i++) {
            BigInteger number = BigInteger.valueOf(arr[i]);
            if (number.compareTo(max) >= 1) {
                max = number;
            }
            if (-1 >= number.compareTo(min)) {
                min = number;
            }
            // sum += number;
            sum = sum.add(number);
        }
        System.out.println(sum.subtract(max) + " " + sum.subtract(min));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 총 다섯개의 숫자를 받아서 최조값과 최대값 추출
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
