package yk.InterviewPreparationKit.HackerRank_WarmUpChallenges;

import java.util.HashSet;
import java.util.Set;

class SudokuTester {

    private static final int[][] VALID_SUDOKU_SOLUTION = {
            // @formatter:off
            {5,3,4,  6,7,8,  9,1,2},
            {6,7,2,  1,9,5,  3,4,8},
            {1,9,8,  3,4,2,  5,6,7},

            {8,5,9,  7,6,1,  4,2,3},
            {4,2,6,  8,5,3,  7,9,1},
            {7,1,3,  9,2,4,  8,5,6},

            {9,6,1,  5,3,7,  2,8,4},
            {2,8,7,  4,1,9,  6,3,5},
            {3,4,5,  2,8,6,  1,7,9}
            // @formatter:on
    };

    private static final int[][] INVALID_SUDOKU_SOLUTION = {
            // @formatter:off
            {5,3,4,  6,7,8,  9,1,2},
            {6,7,2,  1,9,5,  3,4,8},
            {1,9,8,  3,4,2,  5,6,7},

            {8,5,9,  7,6,1,  4,2,3},
            {4,2,6,  8,5,3,  7,9,1},
            {7,1,3,  9,2,4,  8,5,6},

            {9,6,1,  5,3,1,  2,8,4},
            {2,8,7,  4,1,9,  6,3,5},
            {3,4,5,  2,8,6,  1,7,9}
            // @formatter:on
    };

    public static void main(String[] args) {
        System.out.println("should return 'valid':     "
                + (isValidSudoku(VALID_SUDOKU_SOLUTION) ? "valid" : "invalid"));
        System.out.println("should return 'invalid':   "
                + (isValidSudoku(INVALID_SUDOKU_SOLUTION) ? "valid" : "invalid"));
    }

    /**
     * Checks whether the given two-dimensional array {@code a} is a valid sudoku solution.
     *
     * The array is a valid solution if and only if:
     * <ul>
     *   <li>each row (of 9 elements) contains only unique numbers</li>
     *   <li>each column (of 9 elements) contains only unique numbers</li>
     *   <li>each box of 3x3 (as grouped above) contains only unique numbers</li>
     * </ul>
     *
     * Description of the input array:
     * <ul>
     *   <li>the size of the outer array is exactly 9 (9 rows)</li>
     *   <li>the size of every inner array is exactly 9 (9 columns)</li>
     *   <li>all elements are as expected valid Sudoku numbers (integers from 1 to 9)</li>
     * </ul>
     * It is unnecessary to check preconditions in this method.
     *
     * @return true if the argument {@code a} is a valid sudoku solution; false otherwise
     */
    private static boolean isValidSudoku(int[][] a) {
        for (int row=0;row<9;row++)
            for (int col=0;col<9;col++)
            {
                if(!isOk(row,col,a)) {
                    return false;
                }
            }

        return true;
    }


    public static final int SIZE = 9;

    private static boolean isInRow(int row,int[][] a) {
        Set<Integer> listOfNumber = new HashSet();

        for (int i = 0; i < SIZE; i++)
            if (!listOfNumber.add(a[row][i]))
                return true;

        return false;
    }

    private static boolean isInCol(int col,int[][] a) {
        Set<Integer> listOfNumber = new HashSet();

        for (int i = 0; i < SIZE; i++)
            if (!listOfNumber.add(a[i][col]))
                return true;

        return false;
    }

    private static boolean isInBox(int row, int col,int[][] a) {
        int r = row - row % 3;
        int c = col - col % 3;
        Set<Integer> listOfNumber = new HashSet();


        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (!listOfNumber.add(a[i][j]))
                    return true;

        return false;
    }

    private static boolean isOk(int row, int col,int[][] a) {
        return !isInRow(row,a)  &&  !isInCol(col,a)  &&  !isInBox(row, col, a);
    }
}