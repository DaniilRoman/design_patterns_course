package BridgePattern.Matrix.Decorator;

import BridgePattern.Drawer.IDrawer;
import BridgePattern.Matrix.IDrawbleEx;
import BridgePattern.Matrix.IMatrix;
import BridgePattern.Matrix.IMatrixEx;


public abstract class MatrixDecorator implements IMatrixEx {

    protected IMatrix matrix;
    protected IDrawer drawer;

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
        this.drawer = drawer;
        this.matrix.setDrawer(this);
    }

    @Override
    public void drawBorder(int height, int width) {
        drawer.drawBorder(height, width);
    }

    @Override
    public void draw(boolean isBorder) {
        matrix.draw(isBorder);
    }


}
