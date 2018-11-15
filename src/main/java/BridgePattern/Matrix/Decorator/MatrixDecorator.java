package BridgePattern.Matrix.Decorator;

import BridgePattern.Drawer.IDrawer;
import BridgePattern.Matrix.IDrawbleEx;
import BridgePattern.Matrix.IMatrix;
import BridgePattern.Matrix.IMatrixEx;
import BridgePattern.Matrix.Iterator.DrawItemFunc;
import BridgePattern.Matrix.Iterator.IIterator;

import java.util.function.Consumer;


public abstract class MatrixDecorator implements IMatrixEx, IIterator {

    protected IMatrix matrix;
    protected IDrawer drawer;

    private DrawItemFunc func = (int i, int j, Integer value) -> drawItem(i, j, value);

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
        this.matrix.setDrawer(drawer);
    }

    @Override
    public void drawBorder(int height, int width) {
        drawer.drawBorder(height, width);
    }

    @Override
    public void draw(boolean isBorder) {
//        matrix.draw(isBorder);
        iterate(func);

    }

    @Override
    public void iterate(DrawItemFunc func) {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
//                drawItem(i, j, get(i, j));
                func.apply(i, j, get(i, j));
            }
        }
    }

}
