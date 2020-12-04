package yk.InterviewPreparationKit.CTCI_Chapter2_LinkedLists;

public class TwoPointerTechnique {
//   The input array is sorted.
//   Complexity:  O(n)
    public static boolean isPairSum(int arr[], int expectedSum)
    {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {

            if (arr[i] + arr[j] == expectedSum) {
                System.out.println(arr[i] + " + " +arr[j] +" = " + expectedSum);
                return true;
            }
            else if (arr[i] + arr[j] < expectedSum)
                i++;
            else
                j--;
        }

        return false;
    }

//   The input array is not sorted.
//  Complexity: O(n^2)
    public static boolean isPairSumWithoutSorted(int arr[], int expectedSum)
    {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i] + arr[j] == expectedSum)
                    return true;

                if (arr[i] + arr[j] > expectedSum)
                    break; // as the array is sorted
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int arr[] = { 3, 5, 9, 10, 11 };
        int expectedSum = 21;
        System.out.println(isPairSum(arr, expectedSum));

        int array[] = { 9, 5, 3, 10, 11 };
        System.out.println(isPairSumWithoutSorted(array, expectedSum));

    }
}
