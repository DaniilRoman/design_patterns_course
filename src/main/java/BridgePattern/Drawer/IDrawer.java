package BridgePattern.Drawer;

import BridgePattern.Matrix.Matrix;

import java.io.IOException;

public interface IDrawer {

    void drawBorder(int height, int width);

    void drawItem(Matrix matrix) throws IOException;
}
