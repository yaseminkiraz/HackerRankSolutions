package yk.InterviewPreparationKit.CTCI_Chapter1_ArraysAndStrings;

public class P07_StringRotation {

    private static String leftrotate(String str, int d)
    {
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }

    private static String rightrotate(String str, int d)
    {
        return leftrotate(str, str.length() - d);
    }

    public static void main(String args[])
    {
        String str1 = "YaseOrYase";
        System.out.println(leftrotate(str1, 4));

        String str2 = "YaseOrYase";
        System.out.println(rightrotate(str2, 4));
    }
}
