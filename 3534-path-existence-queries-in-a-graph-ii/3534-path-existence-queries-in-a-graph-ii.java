import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] nodes = new int[n][2];

        for (int index = 0; index < n; index++) {
            nodes[index][0] = nums[index];
            nodes[index][1] = index;
        }

        Arrays.sort(nodes, (a, b) -> Integer.compare(a[0], b[0]));

        int[] sortedValues = new int[n];
        int[] originalToSorted = new int[n];

        for (int sortedIndex = 0; sortedIndex < n; sortedIndex++) {
            sortedValues[sortedIndex] = nodes[sortedIndex][0];
            originalToSorted[nodes[sortedIndex][1]] = sortedIndex;
        }

        int[] farthestReach = new int[n];
        int rightPointer = 0;

        for (int leftPointer = 0; leftPointer < n; leftPointer++) {
            while (rightPointer + 1 < n &&
                   sortedValues[rightPointer + 1] - sortedValues[leftPointer] <= maxDiff) {
                rightPointer++;
            }
            farthestReach[leftPointer] = rightPointer;
        }

        int maxLog = 20;
        int[][] jump = new int[maxLog][n];

        for (int index = 0; index < n; index++) {
            jump[0][index] = farthestReach[index];
        }

        for (int level = 1; level < maxLog; level++) {
            for (int index = 0; index < n; index++) {
                jump[level][index] = jump[level - 1][jump[level - 1][index]];
            }
        }

        int[] answer = new int[queries.length];

        for (int queryIndex = 0; queryIndex < queries.length; queryIndex++) {
            int nodeU = queries[queryIndex][0];
            int nodeV = queries[queryIndex][1];

            int leftPos = originalToSorted[nodeU];
            int rightPos = originalToSorted[nodeV];

            if (leftPos > rightPos) {
                int temp = leftPos;
                leftPos = rightPos;
                rightPos = temp;
            }

            if (leftPos == rightPos) {
                answer[queryIndex] = 0;
                continue;
            }

            int currentPos = leftPos;
            int steps = 0;

            for (int level = maxLog - 1; level >= 0; level--) {
                if (jump[level][currentPos] < rightPos) {
                    currentPos = jump[level][currentPos];
                    steps += (1 << level);
                }
            }

            if (jump[0][currentPos] >= rightPos) {
                answer[queryIndex] = steps + 1;
            } else {
                answer[queryIndex] = -1;
            }
        }

        return answer;
    }
}