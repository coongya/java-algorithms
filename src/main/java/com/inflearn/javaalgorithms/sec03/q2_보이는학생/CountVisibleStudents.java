package com.inflearn.javaalgorithms.sec03.q2_보이는학생;

import java.util.Scanner;

public class CountVisibleStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        CountVisibleStudents countVisibleStudents = new CountVisibleStudents();
        System.out.println(countVisibleStudents.solution(n, array));
    }

    public int solution(int n, int[] array) {
        int count = 1;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                count++;
                max = array[i];
            }
        }
        return count;
    }
}
