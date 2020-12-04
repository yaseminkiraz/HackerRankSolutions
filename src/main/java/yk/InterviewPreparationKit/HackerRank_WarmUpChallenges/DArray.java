package yk.InterviewPreparationKit.HackerRank_WarmUpChallenges;
//https://www.hackerrank.com/challenges/2d-array/problem

import java.util.Scanner;


public class DArray {

    private static int hourglassSum(int[][] arr) {

        int sum = -64;
        for(int i =0; i<4; i++){
            for(int j=0; j<4; j++){
                int temp = arr[i][j] + arr[i][j+1] +arr[i][j+2]
                        +arr[i+1][j+1] +arr[i+2][j] +arr[i+2][j+1] + arr[i+2][j+2];
                if(temp>sum){
                    sum = temp;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        System.out.println(hourglassSum(arr));
    }
}
