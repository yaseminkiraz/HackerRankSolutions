package yk.InterviewPreparationKit.CTCI_Chapter1_ArraysAndStrings;

/**
 * URLify: Write a method to replace all spaces in a string with '%20':
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 *  and that you are given the "true" length of the string.
 * (Note: If implementing in Java, please use a character array so that you can perform
 * this operation in place.)
 *
 *  * Input  : "Mr John Smith"
 *  * Output : "Mr%20John%20Smith"
 **/

public class P03_Urlify {

    private static int MAX = 1000;

    private static char[] replaceSpaces(char[] str)
    {
        int space_count = 0;
        int i;

        for (i = 0; i < str.length; i++)
            if (str[i] == ' ')
                space_count++;

        while (str[i - 1] == ' ')
        {
            space_count--;
            i--;
        }

        int new_length = i + space_count * 2;

        if (new_length > MAX)
            return str;

        int index = new_length - 1;

        char[] old_str = str;
        str = new char[new_length];

        for (int j = i - 1; j >= 0; j--)
        {
            if (old_str[j] == ' ')
            {
                str[index] = '0';
                str[index - 1] = '2';
                str[index - 2] = '%';
                index = index - 3;
            }
            else
            {
                str[index] = old_str[j];
                index--;
            }
        }
        return str;
    }


    public static void main(String[] args){
        System.out.print(replaceSpaces("Mr John".toCharArray()));
    }
}
