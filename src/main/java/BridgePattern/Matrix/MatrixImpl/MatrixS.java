package BridgePattern.Matrix.MatrixImpl;

import BridgePattern.Matrix.Matrix;
import BridgePattern.Vector.IVector;
import BridgePattern.Vector.VectorImpl.VectorS;


public class MatrixS extends Matrix {

    public MatrixS(int row, int col) {
        super(row, col);
    }

    @Override
    public void draw(boolean isBorder) {
        if(isBorder) {
            drawer.drawBorder(getRows(), getCols());
        }
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                Integer value = get(i, j);
                if(value != null) {
                    drawer.drawItem(i, j, value);
                }
            }
        }
    }

    @Override
    protected IVector createVector(int col) {
        return new VectorS(col);
    }
}
