package gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import sorting.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingVisualizer extends Application {
    private int[] mainArray;
    private ArrayDisplay insertionSortDisplay;
    private ArrayDisplay quickSortDisplay;
    private ArrayDisplay bubbleSortDisplay;
    private ArrayDisplay mergeSortDisplay;
    private static int arraySize = 50;


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sorting Algorithm Visualizer");

        // ComboBox for array lenght customization for user
        ComboBox<Integer> sizeSelector = new ComboBox<>();
        sizeSelector.getItems().addAll(10, 20, 30, 45, 50, 75, 100);
        sizeSelector.setValue(arraySize);  // 50 = DEFAULT
        sizeSelector.setOnAction(e -> arraySize = sizeSelector.getValue());

        // Start Sorting button
        Button startButton = new Button("Sort");
        startButton.setOnAction(e -> startSorting());

        // Generate array button
        Button randomizeButton = new Button("Generate new Array");
        randomizeButton.setOnAction(e -> randomizeArray());

        // SizeBox section
        HBox sizeBox = new HBox(10, new Label("ArraySize:"), sizeSelector);
        sizeBox.setAlignment(Pos.CENTER);

        // Button section
        HBox buttonBox = new HBox(10, randomizeButton, startButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Array visualisation area
        insertionSortDisplay = new ArrayDisplay(400, 300);
        quickSortDisplay = new ArrayDisplay(400, 300);
        mergeSortDisplay = new ArrayDisplay(400, 300);
        bubbleSortDisplay = new ArrayDisplay(400, 300);

        // Labels
        Label quickSortLabel = new Label("Quick Sort");
        Label bubbleSortLabel = new Label("Bubble Sort");
        Label mergeSortLabel = new Label("Merge Sort");
        Label insertionSortLabel = new Label("Insertion Sort");

        VBox quickSortBox = new VBox(5, quickSortLabel, quickSortDisplay);
        VBox bubbleSortBox = new VBox(5, bubbleSortLabel, bubbleSortDisplay);
        VBox mergeSortBox = new VBox(5, mergeSortLabel, mergeSortDisplay);
        VBox insertionSortBox = new VBox(5, insertionSortLabel, insertionSortDisplay);

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.add(quickSortBox,0,0);
        gridPane.add(bubbleSortBox,1,0);
        gridPane.add(mergeSortBox,0,1);
        gridPane.add(insertionSortBox,1,1);
        gridPane.add(buttonBox,0,3,2,1);
        gridPane.add(sizeBox,0,2,2,1);


        Scene scene = new Scene(gridPane, 825, 760);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Generate array for the 1st time
        randomizeArray();
    }

    private void randomizeArray() {
        Random rand = new Random();
        this.mainArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            mainArray[i] = rand.nextInt(996) + 5; // Range 5-1000
        }
        quickSortDisplay.setArr(mainArray.clone());
        bubbleSortDisplay.setArr(mainArray.clone());
        mergeSortDisplay.setArr(mainArray.clone());
        insertionSortDisplay.setArr(mainArray.clone());
    }

    private void startSorting(){
        animateSort(quickSortDisplay, new QuickSort(), mainArray.clone());
        animateSort(bubbleSortDisplay, new BubbleSort(), mainArray.clone());
        animateSort(mergeSortDisplay, new MergeSort(), mainArray.clone());
        animateSort(insertionSortDisplay, new InsertionSort(), mainArray.clone());
    }

    //https://docs.oracle.com/javase/8/javafx/api/javafx/animation/Timeline.html
    private void animateSort(ArrayDisplay display, SortingAlgorithm algorithm, int[] array) {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);  //Only 1 cycle

        List<int[]> steps = new ArrayList<>(); //List for sorting steps

        // Sort and save steps
        algorithm.sort(array, (stepArray) -> steps.add(stepArray.clone()));

        for (int i = 0; i < steps.size(); i++) {
            final int index = i;
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(20 * index), e -> display.setArr(steps.get(index))));
        }

        timeline.setOnFinished(e -> display.flagSorted());
        timeline.playFromStart(); // Start Animation
    }



    public static void main(String[] args) {
        launch(args);
    }
}
