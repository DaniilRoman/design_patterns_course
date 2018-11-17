package BridgePattern.Matrix.MatrixImpl;

import BridgePattern.Matrix.Iterator.DrawItemFunc;
import BridgePattern.Matrix.Matrix;
import BridgePattern.Vector.IVector;
import BridgePattern.Vector.VectorImpl.VectorS;


public class MatrixS extends Matrix {

    public MatrixS(int row, int col) {
        super(row, col);
    }

    @Override
    public void iterate(DrawItemFunc func) {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                Integer value = get(i, j);
                if(value != null) {
                    func.apply(i, j, value);
                }
            }
        }
    }

    @Override
    protected IVector createVector(int col) {
        return new VectorS(col);
    }

}
