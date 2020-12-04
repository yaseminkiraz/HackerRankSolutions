package yk.InterviewPreparationKit.CTCI_Chapter1_ArraysAndStrings;

public class P06_StringCompression {

    /**
     * String Compression: Implement a method to perform basic string compression using the counts
     * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
     * "compressed "string would not become smaller than the original string, your method should return
     * the original string. You can assume the string has only uppercase and lowercase letters (a - z),
     * */

    private static String compress(String str) {


        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuilder builder = new StringBuilder();

        Character previous = null;
        int count = 0;

        for (Character current : str.toCharArray()) {
            if (previous == null) {
                previous = current;
                count++;
                continue;
            }

            if (previous.equals(current)) {
                count++;
            } else {
                builder.append(previous.toString() + count);
                count = 1;
            }
            previous = current;
        }
        builder.append(previous.toString() + count);

        return str.length() < builder.length() ? str : builder.toString();
    }

    public static void main(String[] args){
        System.out.print(compress("yaseeeeeeeeemen"));
    }
}
