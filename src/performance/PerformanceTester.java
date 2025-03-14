package performance;

import sorting.SortingAlgorithm;

public class PerformanceTester {
    public static long measureSortingTime(SortingAlgorithm algorithm, int[] arr){
        long startTime = System.nanoTime();
        algorithm.sort(arr);
        long endTime = System.nanoTime();
        return (long) endTime - startTime;
    }
}
