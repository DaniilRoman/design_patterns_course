package BridgePattern.Matrix.Composite;

import BridgePattern.Drawer.IDrawer;
import BridgePattern.Matrix.IMatrix;


public class HorizontalGroup extends Group{

    public HorizontalGroup() {
        super();
    }

    public void addMatrix(IMatrix matrix) {
        super.addMatrix(matrix, matrix.getCols());
    }

    @Override
    public Integer get(int row, int col) {
        int matrixIndex = getaway.get(col);
        if(row>=group.get(matrixIndex).getRows()) {
            return null;
        }
        int trueCol = col - offsets.get(matrixIndex);
        return group.get(matrixIndex).get(row, trueCol);
    }

    @Override
    public void set(int row, int col, Integer value) {
        int matrixIndex = getaway.get(col);
        int trueCol = col - offsets.get(matrixIndex);
        group.get(matrixIndex).set(row, trueCol, value);
    }

    @Override
    public int getRows() {
        return getMax(IMatrix::getRows);
    }

    @Override
    public int getCols() {
        return getSum((IMatrix::getCols));
    }

    @Override
    public void drawItem(int yCord, int xCord, Integer value) {
        int matrixIndex = getaway.get(xCord);
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
