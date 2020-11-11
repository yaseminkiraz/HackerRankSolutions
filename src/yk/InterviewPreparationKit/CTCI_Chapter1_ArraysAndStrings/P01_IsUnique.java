package yk.InterviewPreparationKit.CTCI_Chapter1_ArraysAndStrings;

/*Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
    cannot use additional data structures?
*/

public class P01_IsUnique {

/*    Hints::
**    Try a hash table
**   Could a bit vector be useful?
**  Can you solve it in 0(N lo g N) time? What might a solution like that look like?
 */

//    Is the string an ASCII string or a Unicode string?
//ASCII defines 128 characters, ASCII extended 256 chars, Unicode defines (less than) 2^21 characters.

    private static boolean isUniqueStr(String str){
        final int ASCII_EXTENDED_CHAR = 256;

        boolean[] char_set = new boolean[ASCII_EXTENDED_CHAR];

        if (str == null || str.isEmpty() || str.length() > ASCII_EXTENDED_CHAR)
            return false;


        for (Character character: str.toCharArray())
        {
            if(char_set[(int)character])
                return false;

            char_set[(int)character] = true;
        }

        return true;
    }

    public static void main(String args[])
    {
        System.out.println("yasemin: " +isUniqueStr("yasemin"));
        System.out.println("hello: " + isUniqueStr("hello"));
    }
}
