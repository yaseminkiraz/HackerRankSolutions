package yk.InterviewPreparationKit.HackerRank_WarmUpChallenges;
//https://www.hackerrank.com/challenges/counting-valleys/problem

import java.util.Scanner;

public class CountingValleys {
    private static int countingValleys(int n, String s) {
        int level = 0;
        int dCount = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'U'){
                level++;
            }else{
                if(level == 0){
                    dCount++;
                }
                level--;
            }
        }
        return dCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        System.out.println(result);
    }
}
