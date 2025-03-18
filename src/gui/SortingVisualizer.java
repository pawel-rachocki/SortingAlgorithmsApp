package gui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class SortingVisualizer extends Application {
    private ArrayDisplay arrayDisplay;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GUI - Sorting Algorithms Visualizer");

        Button startButton = new Button("Sort");

        //Display array frame/window
        arrayDisplay = new ArrayDisplay(800,600);

        VBox layout = new VBox(10);
        layout.getChildren().add(startButton);

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }


}
