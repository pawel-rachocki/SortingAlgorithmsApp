package sorting;

import java.util.function.Consumer;
//https://www.baeldung.com/java-quicksort

public class QuickSort implements SortingAlgorithm {
    @Override
    public void sort(int[] arr, Consumer<int[]> stepConsumer) {
        quickSort(arr, 0, arr.length - 1, stepConsumer);
    }

    private void quickSort(int[] arr, int low, int high, Consumer<int[]> stepConsumer) {
        if (low < high) {
            int pi = partition(arr, low, high, stepConsumer);
            quickSort(arr, low, pi - 1, stepConsumer);
            quickSort(arr, pi + 1, high, stepConsumer);
        }
    }

    private int partition(int[] arr, int low, int high, Consumer<int[]> stepConsumer) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
                stepConsumer.accept(arr.clone()); // Save array
            }
        }

        swap(arr, i + 1, high);
        stepConsumer.accept(arr.clone()); // Save array
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }
}

