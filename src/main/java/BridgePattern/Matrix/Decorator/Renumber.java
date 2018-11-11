package BridgePattern.Matrix.Decorator;


import BridgePattern.Matrix.IMatrix;

import java.util.HashMap;
import java.util.Map;

public class Renumber extends MatrixDecorator {

    private Map<Integer, Integer> renumberCols;
    private Map<Integer, Integer> renumberRows;

    public Renumber(IMatrix matrix) {
        super(matrix);
        renumberCols = new HashMap<>();
        renumberRows = new HashMap<>();
    }

    public void renumberCols(int i, int j) {
        renumberCols.put(i, j);
        renumberCols.put(j, i);
    }

    public void renumberRows(int i, int j) {
        renumberRows.put(i, j);
        renumberRows.put(j, i);
    }

    @Override
    public Integer get(int row, int col) {
        if(renumberRows.get(row) != null) {
            row = renumberRows.get(row);
        }
        if(renumberCols.get(col) != null) {
            col = renumberCols.get(col);
        }
        return matrix.get(row, col);
    }

    @Override
    public void set(int row, int col, Integer value) {
        if(renumberRows.get(row) != null) {
            row = renumberRows.get(row);
        }
        if(renumberCols.get(col) != null) {
            col = renumberCols.get(col);
        }
        matrix.set(row, col, value);
    }

    @Override
    public void drawItem(int yCord, int xCord, Integer value) {
        if(renumberRows.get(xCord) != null) {
            xCord = renumberRows.get(xCord);
        }
        if(renumberCols.get(yCord) != null) {
            yCord = renumberCols.get(yCord);
        }
        drawer.drawItem(yCord, xCord, value);
    }
}
