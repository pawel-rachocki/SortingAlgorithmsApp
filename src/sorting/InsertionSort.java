package sorting;

import java.util.function.Consumer;

public class InsertionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] arr, Consumer<int[]> stepConsumer) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                stepConsumer.accept(arr.clone()); // Aktualizacja stanu tablicy
            }
            arr[j + 1] = key;
            stepConsumer.accept(arr.clone());
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}
