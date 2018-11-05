package BridgePattern.Matrix.MatrixImpl;

import BridgePattern.Matrix.Matrix;
import BridgePattern.Vector.IVector;
import BridgePattern.Vector.VectorImpl.VectorN;

public class MatrixN extends Matrix {

    public MatrixN(int row, int col) {
        super(row, col);
    }

    @Override
    public void drawItem(int yCord, int xCord, Integer value) {
        drawer.drawItem(yCord, xCord, value);
    }

    @Override
    protected IVector createVector(int col) {
        return new VectorN(col);
    }
}
