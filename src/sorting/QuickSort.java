package sorting;

//https://www.baeldung.com/java-quicksort
public class QuickSort implements SortingAlgorithm{
    public void sort(int[] arr){}

    @Override
    public String getName() {
        return "QuickSort";
    }

    private void quickSort(int[] arr, int low, int high){
        int pivotIndex = partition(arr,low,high);
        quickSort(arr,low,pivotIndex - 1);
        quickSort(arr,pivotIndex + 1, high);
    }
    private int partition(int[] arr, int low, int high){
        int pivot = arr[high]; // Let the last element be pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1; // New pos for pivot
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
