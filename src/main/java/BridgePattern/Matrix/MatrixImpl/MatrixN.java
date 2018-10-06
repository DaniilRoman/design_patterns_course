package BridgePattern.Matrix.MatrixImpl;

import BridgePattern.Matrix.Matrix;
import BridgePattern.Vector.VectorImpl.VectorN;

public class MatrixN extends Matrix {

    public MatrixN(int row, int col) {
        for (int i = 0; i<row; i++) {
            createVector(new VectorN(col));
        }
    }
}
