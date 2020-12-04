package yk.InterviewPreparationKit.CTCI_Chapter1_ArraysAndStrings;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they
 * are one edit (or zero edits) away.
 **/
public class P05_OneWay {

    private static boolean areMaxOneEdit(String string1, String string2) {
        return string1.length() >= string2.length()
                ? hasMaxOneEdit(string1, string2)
                : hasMaxOneEdit(string2, string1);
    }

    private static boolean hasMaxOneEdit(String string1, String string2) {

        int[] charMap = new int[256];
        for (Character c : string1.toCharArray()) {
            charMap[(int)c]++;
        }

        for (Character c : string2.toCharArray()) {
            charMap[(int)c]--;
        }

        int changeCount = 0;
        for (int i = 0; i < charMap.length; i++) {
            if (charMap[i] > 0) {
                changeCount++;
            }
        }

        return changeCount <= 1;
    }

    public static void main(String[] args){
        System.out.print(areMaxOneEdit("yase", "tase"));
    }
}
