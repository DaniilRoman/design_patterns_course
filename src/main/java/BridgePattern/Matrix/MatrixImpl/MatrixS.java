package BridgePattern.Matrix.MatrixImpl;

import BridgePattern.Matrix.Matrix;
import BridgePattern.Vector.IVector;
import BridgePattern.Vector.VectorImpl.VectorS;


public class MatrixS extends Matrix {

    public MatrixS(int row, int col) {
        super(row, col);
    }

    @Override
    public void drawItem(int yCord, int xCord, Integer value) {
        if(value != null) {
            drawer.drawItem(yCord, xCord, value);
        }
    }

    @Override
    protected IVector createVector(int col) {
        return new VectorS(col);
    }
}
