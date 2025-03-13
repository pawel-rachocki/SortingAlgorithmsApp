
//https://en.wikipedia.org/wiki/Merge_sort
//https://www.baeldung.com/java-merge-sort

public class MergeSort implements SortingAlgorithm{
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1){
            return; //no need to sort
        }
        mergesort(arr,0,arr.length - 1);

    }

    @Override
    public String getName() {
        return null;
    }


    private void mergesort(int[] arr, int left, int right){
        if (left < right){
            int mid = left + (right - left) / 2;
            mergesort(arr,left,mid);
            mergesort(arr,mid + 1, right);
            merge(arr,left,mid,right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temp arrays for left and right side
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data into temp arrays
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        // Merge temp arrays
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
        }

        // Copy rest of the elements from left array - if exist
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy rest of the elements from right array - if exist
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
