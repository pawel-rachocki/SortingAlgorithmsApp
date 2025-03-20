package gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import java.util.Random;

public class ArrayDisplay extends Canvas {
    private int[] arr;
    private boolean isSorted = false;
    public ArrayDisplay(int width, int height){
        super(width,height);
    }

    public void setArr(int[] array){
        this.arr = array;
        this.isSorted = false;
        drawArray();
    }
    public void flagSorted(){
        this.isSorted = true;
        drawArray();
    }
    
    public void drawArray() {
        if (arr == null) {
            return;
        }
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());

        double barWidth = getWidth() / arr.length;
        double maxHeight = getHeight();

        for (int i = 0; i < arr.length; i++) {
            double barHeight = (arr[i] / 1000.0) * maxHeight; // Scale
            gc.setFill(isSorted ? Color.GREEN : Color.BLUE);
            gc.fillRect(i * barWidth, maxHeight - barHeight, barWidth - 2, barHeight);
        }
    }
}
