package BridgePattern.Matrix.MatrixImpl;

import BridgePattern.Matrix.Matrix;
import BridgePattern.Vector.IVector;
import BridgePattern.Vector.VectorImpl.VectorS;


public class MatrixS extends Matrix {

    public MatrixS(int row, int col) {
        super(row, col);
    }

    @Override
    public void draw() {
        drawBorder(getRows(), getCols());
        for (int i = 0; i< getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                drawItem(i, j, get(i, j));
            }
        }
    }

    @Override
    public void drawItem(int yCord, int xCord, Integer value) {
        if(get(yCord, xCord) != null) {
            drawer.drawItem(yCord, xCord, value);
        }
    }

    @Override
    protected IVector createVector(int col) {
        return new VectorS(col);
    }
}
