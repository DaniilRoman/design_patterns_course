package BridgePattern.Matrix.MatrixImpl;

import BridgePattern.Matrix.Matrix;
import BridgePattern.Vector.VectorImpl.VectorS;

public class MatrixS extends Matrix {

    public MatrixS(int row, int col) {
        for (int i = 0; i<row; i++) {
            createVector(new VectorS(col));
        }
    }
}
