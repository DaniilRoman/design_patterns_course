package BridgePattern.Drawer.DrawerImpl;

import BridgePattern.Drawer.IDrawer;
import BridgePattern.Matrix.Matrix;

import java.io.IOException;

public class DrawerConsole implements IDrawer {
    @Override
    public void drawBorder(int height, int width) {

        for (int i = 0; i < height; i++) {
            System.out.print("[ ");
            for (int j = 0; j < width; j++) {
                System.out.print("  ");
            }
            System.out.println(" ]");
        }

    }

    @Override
    public void drawItem(Matrix matrix) throws IOException {
        Runtime.getRuntime().exec("clear");
        for (int i = 0; i < matrix.getRows(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix.getCols(); j++) {
                System.out.print(" " + matrix.get(i, j) + " ");
            }
            System.out.println(" ]");
        }
    }
}
