package jzoffer;

/**
 * Created by tianen on 2019/3/27
 *
 * @author fanfte
 * @date 2019/3/27
 **/
public class Test20 {

    public static void printMatrixClockWisely(int[][] nums) {
        if (nums == null) {
            return;
        }
        int startx = 0;
        int starty = 0;

        while(startx * 2 < nums.length && starty * 2 < nums[0].length) {
            printMatrixInCircle(nums, startx, starty);
            startx ++;
            starty ++;
        }
    }

    private static void printMatrixInCircle(int[][] nums, int startx, int starty) {
        int endx = nums[0].length - 1 - starty;
        int endy = nums.length - 1 - startx;

        for (int i = startx; i <= endx; i ++) {
            System.out.print(nums[starty][i] + " ");
        }

        if (starty < endy) {
            for (int i = starty + 1; i <= endy; i ++) {
                System.out.print(nums[i][endx] + " ");
            }
        }

        if (starty < endy && startx < endx) {
            for (int i = endx - 1; i >= startx; i--) {
                System.out.print(nums[endy][i] + " ");
            }
        }

        if (startx < endx && starty < endy - 1) {
            for (int i = endy - 1; i >= starty + 1; i--) {
                System.out.print(nums[i][starty] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] numbers = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };
        printMatrixClockWisely(numbers);
        System.out.println();
        int[][] numbers2 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {22, 23, 24, 25, 26, 27, 28, 9},
                {21, 36, 37, 38, 39, 40, 29, 10},
                {20, 35, 34, 33, 32, 31, 30, 11},
                {19, 18, 17, 16, 15, 14, 13, 12},
        };
        printMatrixClockWisely(numbers2);
        System.out.println();
        int[][] numbers3 = {
                {1, 2, 3, 4, 5, 6, 7, 8}
        };
        printMatrixClockWisely(numbers3);
        System.out.println();
        int[][] numbers4 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {16, 15, 14, 13, 12, 11, 10, 9}
        };
        printMatrixClockWisely(numbers4);
        System.out.println();
        int[][] numbers5 = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8}
        };
        printMatrixClockWisely(numbers5);
        System.out.println();
        int[][] numbers6 = {
                {0, 1},
                {15, 2},
                {14, 3},
                {13, 4},
                {12, 5},
                {11, 6},
                {10, 7},
                {9, 8}
        };
        printMatrixClockWisely(numbers6);
        System.out.println();
        int[][] numbers7 = {
                {1, 2},
                {4, 3}
        };
        printMatrixClockWisely(numbers7);
        System.out.println();
        int[][] numbers8 = {
                {1}
        };
        printMatrixClockWisely(numbers8);
        System.out.println();
        // 0个元素的数组
        printMatrixClockWisely(new int[][]{{}});
        // 空数组
        printMatrixClockWisely(null);
    }
}
