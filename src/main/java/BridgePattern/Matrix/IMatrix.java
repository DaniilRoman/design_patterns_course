package BridgePattern.Matrix;

public interface IMatrix extends IDrawble{

    Integer get(int row, int col);

    void set(int row, int col, Integer value);

    int getRows();

    int getCols();

    default IMatrix getComponent() {
        return this;
    }

    default void draw() {
        drawBorder(getRows(), getCols());
        for (int i = 0; i< getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                drawItem(i, j, get(i, j));
            }
        }
    }

}
