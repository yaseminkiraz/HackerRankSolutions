package yk.InterviewPreparationKit.HackerRank_WarmUpChallenges;
//https://www.hackerrank.com/challenges/sock-merchant/problem

import java.util.*;

public class SalesByMatch {
    private static int sockMerchant(int n, int[] ar) {
        int pairCount=0;

        Set<Integer> socks = new HashSet<>();
        for (int color:ar) {
            if (socks.contains(color)) {
                pairCount++;
                socks.remove(color);
            } else socks.add(color);
        }

        return pairCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] ar = new int[n];
        String[] arItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(result);
    }
}
