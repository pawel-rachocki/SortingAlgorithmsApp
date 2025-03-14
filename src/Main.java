import performance.DataGenerator;
import performance.PerformanceTester;
import sorting.BubbleSort;
import sorting.MergeSort;
import sorting.SortingAlgorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //just for testing
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting algorithm: 1 - Bubble Sort");
        System.out.println("Choose sorting algorithm: 2 - MergeSort");
        int choice = scanner.nextInt();

        SortingAlgorithm algorithm = null;
        if (choice == 1) {
            algorithm = new BubbleSort();
        }
        if (choice == 2) {
            algorithm = new MergeSort();
        }

        int[] array = DataGenerator.generateRandomArray(1000);
        long timeTaken = PerformanceTester.measureSortingTime(algorithm, array);

        System.out.println("Sorting time = " + timeTaken + " ns");
    }
}