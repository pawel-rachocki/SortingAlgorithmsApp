package sorting;

import java.util.function.Consumer;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort(int[] arr, Consumer<int[]> stepConsumer) {
        int temp;
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    stepConsumer.accept(arr.clone()); // Aktualizacja stanu tablicy
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
