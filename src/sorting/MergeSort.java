package sorting;

import java.util.function.Consumer;

public class MergeSort implements SortingAlgorithm {
    @Override
    public void sort(int[] arr, Consumer<int[]> stepConsumer) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergesort(arr, 0, arr.length - 1, stepConsumer);
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }

    private void mergesort(int[] arr, int left, int right, Consumer<int[]> stepConsumer) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergesort(arr, left, mid, stepConsumer);
            mergesort(arr, mid + 1, right, stepConsumer);
            merge(arr, left, mid, right, stepConsumer);
        }
    }

    private void merge(int[] array, int left, int mid, int right, Consumer<int[]> stepConsumer) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
            stepConsumer.accept(array.clone()); // clone updated array
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
            stepConsumer.accept(array.clone());
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
            stepConsumer.accept(array.clone());
        }
    }
}
