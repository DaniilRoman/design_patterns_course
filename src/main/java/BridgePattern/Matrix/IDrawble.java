package BridgePattern.Matrix;

import BridgePattern.Drawer.IDrawer;


public interface IDrawble {
    void draw(boolean isBorder);
    void setDrawer(IDrawer drawer);
}
