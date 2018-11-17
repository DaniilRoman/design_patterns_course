package BridgePattern.Matrix;

import BridgePattern.Drawer.IDrawer;
import BridgePattern.Matrix.Iterator.DrawItemFunc;
import BridgePattern.Matrix.Iterator.IIterator;
import BridgePattern.Vector.IVector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract public class Matrix implements IMatrix {
    protected IDrawer drawer;

    private List<IVector> matrix;

    public Matrix(int row, int col) {
        matrix = new ArrayList<>(0);
        for (int i = 0; i<row; i++) {
            matrix.add(createVector(col));
        }
    }

    @Override
    public void setDrawer(IDrawer drawer) {
        this.drawer = drawer;
    }

    @Override
    public Integer get(int row, int col) {
        return matrix.get(row).get(col);
    }

    @Override
    public void set(int row, int col, Integer value) {
        matrix.get(row).set(col, value);
    }

    @Override
    public int getRows() {
        return matrix.size();
    }

    @Override
    public int getCols() {
        List<Integer> sizesOfRows = new ArrayList<>(0);
        matrix.forEach(vector -> sizesOfRows.add(vector.getSize()));
        return Collections.max(sizesOfRows);
    }

    @Override
    public void draw(boolean isBorder) {
        if(isBorder) {
            drawer.drawBorder(getRows(), getCols());
        }
        iterate((int i, int j, Integer value) -> {drawer.drawItem(i, j, value);});
    }

    protected abstract IVector createVector(int col);
}
