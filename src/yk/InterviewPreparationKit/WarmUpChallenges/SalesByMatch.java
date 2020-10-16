package yk.InterviewPreparationKit.WarmUpChallenges;
//https://www.hackerrank.com/challenges/sock-merchant/problem

import java.util.*;

public class SalesByMatch {
    static int sockMerchant(int n, int[] ar) {
        int pairCount=0;

        Set<Integer> socks = new HashSet<>();
        for (int color:ar) {
            if (socks.contains(Integer.valueOf(color))) {
                pairCount++;
                socks.remove(Integer.valueOf(color));
            } else socks.add(Integer.valueOf(color));
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
