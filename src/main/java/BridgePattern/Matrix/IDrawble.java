package BridgePattern.Matrix;

import BridgePattern.Drawer.IDrawer;


public interface IDrawble {
    void draw();
    void drawItem(int yCord, int xCord, Integer value);
    void setDrawer(IDrawer drawer);
    void drawBorder(int height, int width);
}
