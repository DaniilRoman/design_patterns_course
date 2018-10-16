package BridgePattern.Drawer.DrawerImpl;

import BridgePattern.Drawer.IDrawer;

import java.io.IOException;
import java.util.Optional;

public class DrawerConsole implements IDrawer {

    private String[][] matrix;
    private int height, width;

    @Override
    public void drawBorder(int height, int width) {
        this.height = height;
        this.width = width;
        this.matrix = new String[height][width];

        for (int i = 0; i < height; i++) {
            System.out.print("[ ");
            for (int j = 0; j < width; j++) {
                this.matrix[i][j] = " ";
                System.out.print("   ");
            }
            System.out.println(" ]");
        }

    }

    @Override
    public void drawItem(int yCord, int xCord, Integer value) throws IOException {
        this.matrix[yCord][xCord] = Optional.ofNullable(value).orElse(0).toString();
//        Runtime.getRuntime().exec("clear");
        String tmpValue;
        for (int i = 0; i < height; i++) {
            System.out.print("[ ");
            for (int j = 0; j < width; j++) {
                tmpValue = matrix[i][j];
                if(tmpValue.length() == 1) {
                    tmpValue = tmpValue + " ";
                }
                System.out.print(" " + tmpValue + " ");
            }
            System.out.println(" ]");
        }

        System.out.println();//удалить
    }

}
