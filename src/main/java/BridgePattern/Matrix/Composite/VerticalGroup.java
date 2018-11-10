package BridgePattern.Matrix.Composite;

import BridgePattern.Matrix.IMatrix;
import BridgePattern.Matrix.IMatrixEx;


public class VerticalGroup extends Group {

    public VerticalGroup() {
        super();
    }

    @Override
    public void addMatrix(IMatrixEx matrix) {
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
        if(col<group.get(matrixIndex).getCols()) {
            int trueRow = row - offsets.get(matrixIndex);
            group.get(matrixIndex).set(trueRow, col, value);
        }
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
    public void drawItem(int yCord, int xCord, Integer value) {
        drawItem(yCord, xCord, value, yCord);
    }
}
