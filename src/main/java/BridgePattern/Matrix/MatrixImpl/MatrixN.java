package BridgePattern.Matrix.MatrixImpl;

import BridgePattern.Matrix.Matrix;
import BridgePattern.Vector.IVector;
import BridgePattern.Vector.VectorImpl.VectorN;

public class MatrixN extends Matrix {

    public MatrixN(int row, int col) {
        super(row, col);
    }

    @Override
    public void draw(boolean isBorder) {
        if(isBorder) {
            drawer.drawBorder(getRows(), getCols());
        }
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                drawer.drawItem(i, j, get(i, j));
            }
        }
    }

    @Override
    protected IVector createVector(int col) {
        return new VectorN(col);
    }
}
