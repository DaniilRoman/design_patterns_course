package BridgePattern.Drawer;

import BridgePattern.Matrix.Matrix;

import java.io.IOException;

public interface IDrawer {

    void drawBorder(int height, int width);

    void drawItem(int yCord, int xCord, Integer value) throws IOException;
}
