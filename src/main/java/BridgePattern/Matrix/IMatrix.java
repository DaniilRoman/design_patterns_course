package BridgePattern.Matrix;

public interface IMatrix extends IDrawble{

    Integer get(int row, int col);

    void set(int row, int col, Integer value);

    int getRows();

    int getCols();

    default IMatrix getComponent() {
        return this;
    }

}
