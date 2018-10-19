package BridgePattern.Matrix.MatrixImpl;

import BridgePattern.Matrix.Matrix;
import BridgePattern.Vector.IVector;
import BridgePattern.Vector.VectorImpl.VectorN;
import lombok.AllArgsConstructor;

import java.io.IOException;

public class MatrixN extends Matrix {

    public MatrixN(int row, int col) {
        super(row, col);
    }

    @Override
    public void draw() throws InterruptedException, IOException {
        drawBorder(getRows(), getCols());
        Thread.sleep(1000);
        for (int i = 0; i< getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                drawItem(i, j, get(i, j));
            }
        }
    }

    @Override
    protected IVector createVector(int col) {
        return new VectorN(col);
    }
}
