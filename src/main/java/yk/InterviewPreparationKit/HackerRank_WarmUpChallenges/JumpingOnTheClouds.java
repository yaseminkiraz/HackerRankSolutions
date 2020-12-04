package yk.InterviewPreparationKit.HackerRank_WarmUpChallenges;
//https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem

import java.util.Scanner;

public class JumpingOnTheClouds {

    private static int jumpingOnClouds(int[] c) {
        int jump = 0;
        for (int i = 0; i < c.length-1; i += 2, jump++)
            if (c[i] == 1) i--;
        return jump;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        System.out.println(result);
    }
}
