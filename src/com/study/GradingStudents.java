package com.study;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


    // 1. 받은 성적을 기준으로 성적보다 크고 근접한 5의배수를 구함 - 성적이 73점 이라면 근접한 배수는 75
    // 2. 75에서 73을 뺀값이 3보다 작으면 75로 올린다. 3보다 크거나 변화없음
    // 3. 성적이 38 미만이면 변화없음.
    // 4. 점수는 0 - 100
    // 73 67 38 33
    // 75 67 40 33
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> newGrades = new ArrayList<>();
        for (Integer grade : grades) {
            if (grade == 100 || grade < 38) {
                newGrades.add(grade);
                continue;
            }
            int nextGrade = 0;
            if (grade % 5 == 0) {
                nextGrade = grade + 5;
            } else {
                nextGrade = grade / 5 * 5 + 5;
            }

            if (nextGrade - grade < 3) {
                grade = nextGrade;
            }
            newGrades.add(grade);
        }
        return newGrades;
    }

}

public class GradingStudents {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("PWD") + File.separator + "output.txt"));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
