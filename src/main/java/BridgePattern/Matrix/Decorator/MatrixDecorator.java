package BridgePattern.Matrix.Decorator;

import BridgePattern.Drawer.IDrawer;
import BridgePattern.Matrix.IDrawble;
import BridgePattern.Matrix.IMatrix;


public abstract class MatrixDecorator implements IMatrix, IDrawble{

    protected IMatrix matrix;

    public MatrixDecorator(IMatrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public int getRows() {
        return matrix.getRows();
    }

    @Override
    public int getCols() {
        return matrix.getCols();
    }

    @Override
    public IMatrix getComponent() {
        return matrix.getComponent();
    }

    @Override
    public void setDrawer(IDrawer drawer) {
        matrix.setDrawer(drawer);
    }

    @Override
    public void drawItem(int yCord, int xCord, Integer value) {
        matrix.drawItem(yCord, xCord, value);
    }

    @Override
    public void drawBorder(int height, int width) {
        matrix.drawBorder(height, width);
    }
//
//    @Override
//    public void draw() {
//        matrix.draw();
//    }

}
