package BridgePattern.Matrix;

public interface IMatrixEx extends IMatrix, IDrawbleEx {
    default void draw() {
        drawBorder(getRows(), getCols());
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                drawItem(i, j, get(i, j));
            }
        }
    }
}
