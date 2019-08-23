package com.study.interview.warmup;

import com.study.quiz.Quiz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * find and print the number of letter a's in the first n letters of Lilah's infinite string.
 *
 * 입력받은 문자를 입력받은 숫자만큼의 길이가 될때까지 반복하였을때 a 가 몇개나 나오는지 계산
 *
 * sample input
 * aba
 * 10
 *
 * output
 * 7
 *
 *
 * aba 를 길이가 10이 될때까지 반복 abaabaabaa
 * a는 총 7개가 됨을 리턴.
 *
 */
public class RepeatedString extends Quiz {

    /**
     * @param s The first line contains a single string
     * @param n The second line contains an integer
     * @return
     */
    static long repeatedString(String s, long n) {
        long length = s.length();

        if (isOnlyA(s, length)) {
            return n;
        }

        long letterCnt = getLetterCount(s, 'a');

        long quotient = n / length;

        if (n % length == 0) {
            return quotient * letterCnt;
        } else {
            long more = n - (quotient * length);
            String substring = s.substring(0, (int) more);
            return quotient * letterCnt + getLetterCount(substring, 'a');
        }
    }

    private static long getLetterCount(String s, char letter) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (letter == s.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isOnlyA(String s, long length) {
        return length == 1 && "a".equals(s);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = getBufferedWriter();

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
