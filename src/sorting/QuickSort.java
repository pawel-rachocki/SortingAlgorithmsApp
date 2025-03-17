package sorting;

//https://www.baeldung.com/java-quicksort
public class QuickSort implements SortingAlgorithm {

    public void sort(int[] array) {
        System.out.println("Początkowy stan tablicy:");
        printArray(array);
        quickSort(array, 0, array.length - 1);
    }

    @Override
    public String getName() {
        return "QuickSort";
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            System.out.println("Pivot: " + array[pivotIndex] + " | Nowy podział:");
            printArray(array);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Pivot to ostatni element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
                printArray(array); // Wyświetlamy tablicę po każdej zamianie
            }
        }
        swap(array, i + 1, high);
        printArray(array); // Wyświetlamy tablicę po ostatniej zamianie (pivot na właściwą pozycję)
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
