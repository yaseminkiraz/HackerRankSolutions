package yk.InterviewPreparationKit.CTCI_Chapter1_ArraysAndStrings;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 */
public class P02_CheckPermutation {

//    Is it case sensitive? Is the white space significant?
//    YES.

    private static boolean isPermutation(String str1, String str2){
        if (str1 == null || str2 == null)
            return false;

        if (str1.length() != str2.length())
            return false;

        int[] letters = new int[256];
        for(Character c : str1.toCharArray()) {
            letters[(int)c]++;
        }

        for(Character c : str2.toCharArray()) {
            letters[(int)c]--;
        }

        for (int letter : letters) {
            if (letter > 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(isPermutation("yala","alay"));
        System.out.println(isPermutation("Yala","alay"));
    }
}
