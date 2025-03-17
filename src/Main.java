import performance.DataGenerator;
import performance.PerformanceTester;
import sorting.BubbleSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.SortingAlgorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //just for testing
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting algorithm: 1 - Bubble Sort");
        System.out.println("Choose sorting algorithm: 2 - MergeSort");
        System.out.println("Choose sorting algorithm: 3 - QuickSort");
        int choice = scanner.nextInt();

        SortingAlgorithm algorithm = null;

        switch (choice){
            case 1 -> algorithm = new BubbleSort();
            case 2 -> algorithm = new MergeSort();
            case 3 -> algorithm = new QuickSort();
            default -> {
                break;
            }
        }

        int[] array = DataGenerator.generateRandomArray(5);
        long timeTaken = PerformanceTester.measureSortingTime(algorithm, array);

        System.out.println("Sorting time = " + timeTaken + " ns");
    }
}