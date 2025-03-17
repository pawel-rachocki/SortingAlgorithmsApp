package performance;

import java.util.Random;

public class DataGenerator {
    public static int[] generateRandomArray(int size){
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++){
            arr[i] = rand.nextInt(996) +5; //5-1000 range
        }
        return arr;
    }
}
