package yk.InterviewPreparationKit.HarckerRank_WarmUpChallenges;
//https://www.hackerrank.com/challenges/repeated-string/problem

import java.util.Scanner;

public class RepeatedString {
    private static final char SMALL_CHAR = 'a';

    private static long repeatedString(String s, long n) {
        long totalCount = 0;

        for (int smallStrIndex=0;smallStrIndex<s.length();smallStrIndex++)
            if(s.charAt(smallStrIndex) == SMALL_CHAR)
                totalCount++;

        long divisor = n/s.length();
        long substringLength = n%s.length();
        totalCount = totalCount * divisor;

        for (int index = 0; index < substringLength; index++) {
            if (s.charAt(index) == SMALL_CHAR) {
                totalCount++;
            }
        }
        return totalCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        long n = scanner.nextLong();

        long result = repeatedString(s, n);

        System.out.println(result);
    }
}
