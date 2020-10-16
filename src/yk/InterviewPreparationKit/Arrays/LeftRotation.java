package yk.InterviewPreparationKit.Arrays;
//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem

import java.util.Scanner;

public class LeftRotation{
    static int[] rotLeft(int[] a, int d) {
        int n = a.length;
        int[] temp = new int[n];
        System.arraycopy(a, d, temp, 0, n-d);
        System.arraycopy(a, 0, temp, n-d, d);

        return  temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];
        String[] aItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        scanner.close();
    }
}
