package BridgePattern.Matrix.Composite;

import BridgePattern.Drawer.IDrawer;
import BridgePattern.Matrix.IMatrix;


public class VerticalGroup extends Group {

    public VerticalGroup() {
        super();
    }

    public void addMatrix(IMatrix matrix) {
        super.addMatrix(matrix, matrix.getRows());
    }

    @Override
    public Integer get(int row, int col) {
        int matrixIndex = getaway.get(row);
        if(col>=group.get(matrixIndex).getCols()) {
            return null;
        }
        int trueRow = row - offsets.get(matrixIndex);
        return group.get(matrixIndex).get(trueRow, col);
    }

    @Override
    public void set(int row, int col, Integer value) {
        int matrixIndex = getaway.get(row);
        int trueRow = row - offsets.get(matrixIndex);
        group.get(matrixIndex).set(trueRow, col, value);
    }

    @Override
    public int getRows() {
        return getSum(IMatrix::getRows);
    }

    @Override
    public int getCols() {
        return getMax(IMatrix::getCols);
    }

    @Override
    public IMatrix getComponent() {
        return this;
    }

    @Override
    public void drawItem(int yCord, int xCord, Integer value) {
        int matrixIndex = getaway.get(yCord);
        group.get(matrixIndex).drawItem(yCord, xCord, value);
    }

    @Override
    public void setDrawer(IDrawer drawer) {
        this.drawer = drawer;
        group.forEach(matrix -> matrix.setDrawer(drawer));
    }

    @Override
    public void drawBorder(int height, int width) {
        drawer.drawBorder(height, width);
    }
}
