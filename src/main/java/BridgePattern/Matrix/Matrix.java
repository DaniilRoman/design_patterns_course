package BridgePattern.Matrix;

import BridgePattern.Drawer.IDrawer;
import BridgePattern.Vector.IVector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

abstract public class Matrix implements IMatrix, IDrawble {

    private IDrawer drawer;

    private List<IVector> matrix;

    public Matrix(int row, int col) {
        for (int i = 0; i<row; i++) {
            if(matrix == null){
                matrix = new ArrayList<>(0);
            }
            else{
                matrix.add(createVector(col));
            }
        }
    }

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

    protected void drawBorder(int height, int width) {
        drawer.drawBorder(height, width);
    }

    protected void drawItem(int yCord, int xCord, Integer value) throws IOException {
        drawer.drawItem(yCord, xCord, value);
    }

    protected abstract IVector createVector(int col);
}
