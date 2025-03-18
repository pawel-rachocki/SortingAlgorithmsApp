package gui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import java.util.Random;

public class ArrayDisplay extends Canvas {
    private int[] arr;
    public ArrayDisplay(int width, int height){
        super(width,height);
    }

    public void setArr(int[] array){
        this.arr = array;
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
            gc.setFill(Color.BLUE);
            gc.fillRect(i * barWidth, maxHeight - barHeight, barWidth - 2, barHeight);
        }
    }
}
