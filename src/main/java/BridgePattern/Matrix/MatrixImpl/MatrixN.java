package BridgePattern.Matrix.MatrixImpl;

import BridgePattern.Matrix.Iterator.DrawItemFunc;
import BridgePattern.Matrix.Matrix;
import BridgePattern.Vector.IVector;
import BridgePattern.Vector.VectorImpl.VectorN;

public class MatrixN extends Matrix {

    public MatrixN(int row, int col) {
        super(row, col);
    }

    @Override
    public void iterate(DrawItemFunc func) {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                func.apply(i, j, get(i, j));
            }
        }
    }

    @Override
    protected IVector createVector(int col) {
        return new VectorN(col);
    }

}
