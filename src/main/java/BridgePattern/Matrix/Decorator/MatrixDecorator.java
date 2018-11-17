package BridgePattern.Matrix.Decorator;

import BridgePattern.Drawer.IDrawer;
import BridgePattern.Matrix.IMatrix;
import BridgePattern.Matrix.IMatrixEx;
import BridgePattern.Matrix.Iterator.DrawItemFunc;
import BridgePattern.Matrix.Iterator.IIterator;



public abstract class MatrixDecorator implements IMatrix, IIterator {

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
        this.matrix.setDrawer(drawer);
    }

}
