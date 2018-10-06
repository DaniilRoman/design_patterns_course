package BridgePattern.Matrix;

public interface IMatrix {

    Integer get(int row, int col);

    void set(int row, int col, Integer value);

    int getRows();

    int getCols();

}
