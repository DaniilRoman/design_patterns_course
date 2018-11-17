package BridgePattern.Matrix.Composite;

import BridgePattern.Matrix.IMatrix;
import BridgePattern.Matrix.Iterator.DrawItemFunc;


public class HorizontalGroup extends Group {

    public HorizontalGroup() {
        super();
    }

    @Override
    public void addMatrix(IMatrix matrix) {
        super.addMatrix(matrix, matrix.getCols());
    }

    @Override
    public Integer get(int row, int col) {
        int matrixIndex = getaway.get(col);
        if (row >= group.get(matrixIndex).getRows()) {
            return null;
        }
        int trueCol = col - offsets.get(matrixIndex);
        return group.get(matrixIndex).get(row, trueCol);
    }

    @Override
    public void set(int row, int col, Integer value) {
        int matrixIndex = getaway.get(col);
        if (row < group.get(matrixIndex).getRows()) {
            int trueCol = col - offsets.get(matrixIndex);
            group.get(matrixIndex).set(row, trueCol, value);
        }
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
    public void draw(boolean isBorder) {
        if (isBorder) {
            drawer.drawBorder(getRows(), getCols());
        }

        for (Integer i : offsets.keySet()) {
            offsetForDraw = offsets.get(i);
            group.get(i).iterate((int yCord, int xCord, Integer value) -> {
                drawer.drawItem(yCord, xCord + offsetForDraw, value);
            });
        }

    }

    @Override
    public void iterate(DrawItemFunc func) {
        for (Integer i : offsets.keySet()) {
            offsetForDraw = offsets.get(i);
            group.get(i).iterate((int yCord, int xCord, Integer value) -> {
                func.apply(yCord, xCord + offsetForDraw, value);
            });
        }
    }
}
