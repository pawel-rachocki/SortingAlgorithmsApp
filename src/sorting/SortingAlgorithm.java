package sorting;

import java.util.function.Consumer;

public interface SortingAlgorithm {
    void sort(int[] arr, Consumer<int[]> stepConsumer);
    String getName();
}
