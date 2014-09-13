package puzzles.datastructures.algos.arrays;

public class MaxSumSubArray {

    public static void main(String[] args) {
//        int a[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
         int a[] = { 2, 4, -5, 6, 8, -5, 3, -4, -11, 2, 99 };

        int[] maxSumSubArray = maxSumSubArrayKadane(a);
        printArray(maxSumSubArray);

        maxSumSubArray = maxSumSubArrayDeepak(a);
        printArray(maxSumSubArray);

    }

    private static int[] maxSumSubArrayDeepak(int[] a) {
        int[] cumA = new int[a.length];
        cumA[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            cumA[i] = cumA[i - 1] + a[i];
        }
        int maxIndex = 0, max = cumA[0];
        for (int i = 1; i < cumA.length; i++) {
            if (max < cumA[i]) {
                max = cumA[i];
                maxIndex = i;
            }
        }
        int min = cumA[0], minIndex = 0;
        for (int i = 0; i <= maxIndex; ++i) {
            if (min > cumA[i]) {
                min = cumA[i];
                minIndex = i;
            }
        }

        if (min > 0) {
            minIndex = -1;
        }
        int[] longestSumSubArray = new int[maxIndex - minIndex];
        for (int i = minIndex + 1; i <= maxIndex; ++i) {
            longestSumSubArray[i - minIndex - 1] = a[i];
        }

        return longestSumSubArray;
    }

    private static void printArray(int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Returns maximum sum subarray using Kadane's algorithm.
     * 
     * @param a
     * @return
     */
    private static int[] maxSumSubArrayKadane(int[] a) {
        int maxSum = a[0];
        int maxSumEndsHere = a[0];
        int beginMax = 0, beginCur = 0;
        int endMax = 0;
        for (int i = 1; i < a.length; i++) {
            maxSumEndsHere += a[i];
            if (maxSumEndsHere < 0) {
                maxSumEndsHere = 0;
                beginCur = i + 1;
            }
            if (maxSumEndsHere > maxSum) {
                maxSum = maxSumEndsHere;
                beginMax = beginCur;
                endMax = i;
            }
        }
        int[] longestSumSubArray = new int[endMax - beginMax + 1];
        for (int i = beginMax; i <= endMax; ++i) {
            longestSumSubArray[i - beginMax] = a[i];
        }
        return longestSumSubArray;
    }
}
