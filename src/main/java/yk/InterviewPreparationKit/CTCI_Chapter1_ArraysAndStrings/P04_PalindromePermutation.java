package yk.InterviewPreparationKit.CTCI_Chapter1_ArraysAndStrings;

import java.util.HashMap;

/**Palindrome Permutation: Given a string, write a function to check if it is a permutation of
        a palindrome. A palindrome is a word or phrase that is the same forwards and backwards, A
        permutation is a rearrangement of letters. The palindrome does not need to be limited to just
        dictionary words.
        EXAMPLE
        Input: Tac t Coa
        Output: True (permutations: "taco cat""atc o eta" etc.)
**/

public class P04_PalindromePermutation {

// Time complexity : O(n)
// Space complexity : O(1)

    private static boolean isPermutationOfPalindrome(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0) {
                count--;
            }
            else {
                count++;
            }
        }

        return count <= 1;
    }

    public static void main(String[] args){
        System.out.print(isPermutationOfPalindrome("yase a seay"));
    }
}
