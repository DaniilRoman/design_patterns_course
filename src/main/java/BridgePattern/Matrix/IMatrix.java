package BridgePattern.Matrix;

import BridgePattern.Matrix.Iterator.IIterator;

public interface IMatrix extends IDrawble, IIterator {

    Integer get(int row, int col);

    void set(int row, int col, Integer value);

    int getRows();

    int getCols();

    default IMatrix getComponent() {
        return this;
    }

}
