package BridgePattern.Matrix;

import BridgePattern.Drawer.IDrawer;


public interface IDrawble {
    void draw();
    void setDrawer(IDrawer drawer);
}
