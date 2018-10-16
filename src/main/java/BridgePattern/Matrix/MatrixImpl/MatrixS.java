package BridgePattern.Matrix.MatrixImpl;

import BridgePattern.Matrix.Matrix;
import BridgePattern.Vector.VectorImpl.VectorS;

import java.io.IOException;

public class MatrixS extends Matrix {

    public MatrixS(int row, int col) {
        for (int i = 0; i<row; i++) {
            createVector(new VectorS(col));
        }
    }

    @Override
    public void draw() throws InterruptedException, IOException {
        drawBorder(getRows(), getCols());
        Thread.sleep(1000);
        for (int i = 0; i< getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                if(get(i, j) != null) {
                    drawItem(i, j, get(i, j));
                }
            }
        }
    }
}
