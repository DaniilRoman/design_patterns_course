package BridgePattern.Matrix.MatrixImpl;

import BridgePattern.Matrix.Matrix;
import BridgePattern.Vector.IVector;
import BridgePattern.Vector.VectorImpl.VectorN;
import lombok.AllArgsConstructor;

import java.io.IOException;

public class MatrixN extends Matrix {

    public MatrixN(int row, int col) {
        super(row, col, new VectorN());
    }

    public MatrixN(int row, int col, IVector vector) {
        super(row, col, vector);
    }

//    public MatrixN(int row, int col, ) {
//        for (int i = 0; i<row; i++) {
//            createVector(new VectorN(col));
//        }
//    }

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
}
